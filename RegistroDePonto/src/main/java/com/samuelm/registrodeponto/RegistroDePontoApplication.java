package com.samuelm.registrodeponto;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RegistroDePontoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistroDePontoApplication.class, args);
    }

}
