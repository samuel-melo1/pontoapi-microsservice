package com.eletronico.pontoapi.entrypoint.dto.response;

import com.eletronico.pontoapi.core.domain.Cargo;
import com.eletronico.pontoapi.core.domain.Departamento;
import com.eletronico.pontoapi.core.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTOResponse {
    private Integer id_user;
    private String name;
    private String email;
    private Boolean status;
    private Cargo cargo;
    private Departamento departamento;
    private List<Role> permissions;
}
