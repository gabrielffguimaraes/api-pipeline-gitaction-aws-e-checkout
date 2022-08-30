package com.store.market.config;

import org.springframework.amqp.core.DirectExchange;
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

    /*COMMOM MANDATORY CONFIGURATION*/
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }
    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener (
            RabbitAdmin rabbitAdmin
    ) {
        return event -> rabbitAdmin.initialize();
    }
    // MANDATORY FOR COMPLEX OBJECTS
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    // SENDER OBJECT CONFIGURATION
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}
