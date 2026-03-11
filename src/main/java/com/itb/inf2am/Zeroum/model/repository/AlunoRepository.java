package com.itb.inf2am.Zeroum.model.repository;

import com.itb.inf2am.Zeroum.model.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}