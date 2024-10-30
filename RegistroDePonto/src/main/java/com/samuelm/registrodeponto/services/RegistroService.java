package com.samuelm.registrodeponto.services;

import dtos.RegistroPontoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static constants.RabbitMQConstants.EXG_NAME_REGISTROPONTO;
import static constants.RabbitMQConstants.RK_REGISTRO_PONTO;

@Service
@Slf4j
public class RegistroService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void registrarPonto(RegistroPontoDTO dto){
        log.info("Sending a message to exchange: " + dto);
        rabbitTemplate.convertAndSend(EXG_NAME_REGISTROPONTO, RK_REGISTRO_PONTO, dto);
    }
}
