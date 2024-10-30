package com.eletronico.pontoapi.infrastructure.controllers;

import com.eletronico.pontoapi.entrypoint.dto.request.RoleDTO;
import com.eletronico.pontoapi.application.gateways.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService service;
    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Valid RoleDTO dto){
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId_role()).toUri();
        return ResponseEntity.created(uri).body(service.create(dto));
    }
    @GetMapping
    public ResponseEntity<List<RoleDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<RoleDTO>> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
