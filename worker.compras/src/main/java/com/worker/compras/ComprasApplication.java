package com.worker.compras;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ComprasApplication {
	public static void main(String[] args) {
		SpringApplication.run(ComprasApplication.class, args);
	}
}
