package com.samuelm.processamentopontos.application.usecases;

import com.samuelm.processamentopontos.application.gateways.IRegistroPontoService;
import com.samuelm.processamentopontos.core.domain.RegistroPonto;
import com.samuelm.processamentopontos.infrastructure.persistence.RegistroPontoRepository;
import com.samuelm.processamentopontos.utils.MapperDTO;
import dtos.RegistroPontoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static constants.RabbitMQConstants.QUEUE_REGISTRO_PONTO;

@Service
@Slf4j
public class RegistroPontoService implements IRegistroPontoService {

    @Autowired
    private RegistroPontoRepository repository;

    @Override
    @RabbitListener(queues = {QUEUE_REGISTRO_PONTO})
    public void registrarPonto(RegistroPontoDTO dto) {
        RegistroPonto newPonto = new RegistroPonto();
        BeanUtils.copyProperties(dto, newPonto);

        System.out.println(newPonto);
        
        repository.save(newPonto);
    }
}
