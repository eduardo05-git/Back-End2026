package com.itb.inf2am.Zeroum.model.repository;

import com.itb.inf2am.Zeroum.model.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}