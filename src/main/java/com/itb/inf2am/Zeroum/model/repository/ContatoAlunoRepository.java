package com.itb.inf2am.Zeroum.model.repository;

import com.itb.inf2am.Zeroum.model.entity.ContatoAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoAlunoRepository extends JpaRepository<ContatoAluno, Integer> {

    List<ContatoAluno> findByAlunoId(Integer alunoId);

}