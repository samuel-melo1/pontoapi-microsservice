package com.eletronico.pontoapi.entrypoint.controllers;

import com.eletronico.pontoapi.entrypoint.dto.request.UserDTO;
import com.eletronico.pontoapi.services.UserService;
import com.eletronico.pontoapi.utils.validation.OnCreate;
import com.eletronico.pontoapi.utils.validation.OnUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@Validated(OnCreate.class) @RequestBody @Valid UserDTO userDTO) {
        int id_user = service.saveUser(userDTO);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").buildAndExpand(id_user).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                 @RequestParam(name = "size", defaultValue = "10") int size) {
        return ResponseEntity.ok().body(service.listUser(page, size));
    }
    @GetMapping("/{userId}")
    public ResponseEntity<Optional<UserDTO>> findByID(@PathVariable("userId") Integer id){
        return ResponseEntity.ok(service.findUserById(id));
    }

    @GetMapping("/emails")
    public ResponseEntity<Optional<UserDTO>> findByEmail(@RequestParam("email") String email){
        return ResponseEntity.ok(service.findUserByEmail(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@Validated(OnUpdate.class) @RequestBody @Valid UserDTO dto, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.update(dto, id));
    }

}
