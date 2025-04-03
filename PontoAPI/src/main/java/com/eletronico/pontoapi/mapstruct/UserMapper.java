package com.eletronico.pontoapi.mapstruct;

import com.eletronico.pontoapi.core.domain.User;
import com.eletronico.pontoapi.entrypoint.dto.request.UserDTO;
import com.eletronico.pontoapi.entrypoint.dto.response.UserDTOResponse;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDTOResponse responseToEntity(User user);
    User entityToResponse(UserDTOResponse response);
}
