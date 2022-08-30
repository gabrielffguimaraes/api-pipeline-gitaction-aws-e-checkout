package com.worker.compras.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    /*SENDER CONFIGURATION*/
    @Bean
    public DirectExchange directOrderExchange() {
        return new DirectExchange("orders.v1.order");
    }

    /*RECEIVER CONFIGURATION*/
    @Bean
    public Queue receiveOrder() {
        return new Queue("orders.v1.order-created",true);
    }

    @Bean
    public Declarables bindinds() {
        DirectExchange directExchange = new DirectExchange("orders.v1.order");
        Queue queue = receiveOrder();
        return new Declarables(
            BindingBuilder.bind(queue).to(directExchange).with(queue.getName())
        );
    }

    /*COMMOM RABBITMQ CONFIGURATION*/
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }
    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener(
        RabbitAdmin rabbitAdmin
    ) {
        return event -> rabbitAdmin.initialize();
    }
    // MANDATORY CONVERTER FOR COMPLEX OBJECTS
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    // SENDER
    @Bean
    public RabbitTemplate rabbitTemplate(
        ConnectionFactory connectionFactory,
        Jackson2JsonMessageConverter jackson2JsonMessageConverter
    ) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter);
        return rabbitTemplate;
    }
}
