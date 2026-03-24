package com.itb.inf2am.Zeroum.model.repository;

import com.itb.inf2am.Zeroum.model.entity.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidaturaRepository extends JpaRepository<Candidatura, Integer> {

    List<Candidatura> findByAlunoId(Integer alunoId);

    List<Candidatura> findByVagaId(Integer vagaId);

}