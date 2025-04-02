package com.eletronico.pontoapi.services;

import com.eletronico.pontoapi.entrypoint.dto.request.UserDTO;
import com.eletronico.pontoapi.entrypoint.dto.response.UserDTOResponse;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Integer saveUser(UserDTO dto);

    List<UserDTOResponse> findAll(Integer page, Integer pageSize);
    void update(UserDTO dto, Integer id);

    Optional<UserDTOResponse> findById(Integer id);
}
