package com.worker.compras.service.rabbitmq;

import com.worker.compras.model.entity.Address;
import com.worker.compras.model.entity.Order;
import com.worker.compras.service.OrderService;
import com.worker.compras.service.cep.CepService;
import com.worker.compras.service.email.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderConsumer {
    @Autowired
    private OrderService orderService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private CepService cepService;
    @Autowired
    private OrderProducer orderProducer;

    @RabbitListener(queues = "orders.v1.order-created")
    public void orderConsumerListener(Order order) {
        log.info("Receiving order = {}", order);
        try {
            Address address = cepService.pegarEndereco(order.getZipCode());
            log.info("Address got back = {}", address);
        } catch (Exception e) {
            log.info("Error : address not found .");
        }
        Order s = orderService.saveOrder(order);
        log.info("Order saved = {}",s);
        try {
            emailService.notifyClient(order.getEmail());
            orderProducer.sendOrder(order);
        } catch(Exception e) {
            log.info("Error : couldn't notify the client , the receiver email is possibly wrong .");
        }
    }
}
