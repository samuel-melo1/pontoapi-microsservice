package com.samuelm.processamentopontos.infrastructure.controllers;

import dtos.RegistroPontoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static constants.RabbitMQConstants.QUEUE_REGISTRO_PONTO;


@RestController
@Slf4j
public class RegistroPontoController {
}
