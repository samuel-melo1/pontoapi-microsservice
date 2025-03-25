package com.eletronico.pontoapi.services;

import com.eletronico.pontoapi.core.domain.User;
import com.eletronico.pontoapi.entrypoint.dto.request.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Integer saveUser(UserDTO dto);

    List<UserDTO> listUser(Integer page, Integer pageSize);

    Optional<UserDTO> findUserByEmail(String email);
    UserDTO update(UserDTO dto, Integer id);

    Optional<UserDTO> findUserById(Integer id);
}
