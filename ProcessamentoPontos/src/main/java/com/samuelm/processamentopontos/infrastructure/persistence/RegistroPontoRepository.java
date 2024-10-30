package com.samuelm.processamentopontos.infrastructure.persistence;

import com.samuelm.processamentopontos.core.domain.RegistroPonto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, Integer> {
}
