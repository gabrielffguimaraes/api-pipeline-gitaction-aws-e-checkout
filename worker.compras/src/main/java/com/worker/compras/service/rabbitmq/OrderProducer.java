package com.worker.compras.service.rabbitmq;


import com.worker.compras.model.entity.CreditCard;
import com.worker.compras.model.entity.Order;
import com.worker.compras.service.CreditCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrder(Order order) {
        CreditCard creditCard = CreditCard.builder()
                .number(CreditCardService.generateNumber())
                .availableLimit(CreditCardService.generateLimit())
                .build();
        order.setCreditCard(creditCard);
        rabbitTemplate.convertAndSend("orders.v1.order","orders.v1.card-validator", order);
        log.info("Credit card sent for validations = {}",order);
    }
}
