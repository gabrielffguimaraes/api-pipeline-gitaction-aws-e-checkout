package com.store.market.controller;

import com.store.market.model.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1")
public class OrderRestController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
        rabbitTemplate.convertAndSend("orders.v1.order","orders.v1.order-created", order);
        log.info("Sending order = {}", order);
        return order;
    }

}