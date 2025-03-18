package com.eletronico.pontoapi.persistence;

import com.eletronico.pontoapi.core.domain.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

    Optional<Departamento> findByName(String name);
}
