package com.worker.validator.service.rabbitmq;

import com.worker.validator.exceptions.LimitNotValidException;
import com.worker.validator.exceptions.MoneyNotEnoughException;
import com.worker.validator.model.Order;
import com.worker.validator.service.ValidatorService;
import com.worker.validator.service.email.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderValidationConsumer {
    @Autowired
    EmailService emailService;
    @Autowired
    ValidatorService validatorService;

    @RabbitListener(queues = "orders.v1.card-validator")
    public void validOrder(Order order){
       try {
           validatorService.validOrder(order);
           emailService.notifyClient(order.getEmail()
                   ,"Your order is ready and validated !!!"
                   ,"Purchase done successful , congratulations . ");

           log.info("Purchase done successful , congratulations . ");
       } catch (MoneyNotEnoughException | LimitNotValidException e) {
           emailService.notifyClient(order.getEmail()
                   ,"Sorry )`: "
                   ,e.getMessage());
           log.info(e.getMessage());
           e.printStackTrace();
       }
    }
}
