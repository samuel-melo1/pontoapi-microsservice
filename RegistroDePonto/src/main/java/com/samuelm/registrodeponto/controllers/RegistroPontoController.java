package com.samuelm.registrodeponto.controllers;

import com.samuelm.registrodeponto.services.RegistroService;
import dtos.RegistroPontoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registro-ponto")
public class RegistroPontoController {

    @Autowired
    private RegistroService service;

    @PostMapping
    public ResponseEntity<Object> registrarPonto(@RequestBody RegistroPontoDTO dto){
        service.registrarPonto(dto);
        return ResponseEntity.noContent().build();
    }
}
