package com.itb.inf2am.Zeroum.model.repository;

import com.itb.inf2am.Zeroum.model.entity.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Integer> {

    // Buscar vagas pelo status
    List<Vaga> findByStatusVaga(String statusVaga);

    // Buscar vagas por área
    List<Vaga> findByArea(String area);

    // Buscar vagas por cidade
    List<Vaga> findByCidade(String cidade);

    // Buscar vagas por empresa
    List<Vaga> findByEmpresaId(Integer empresaId);
}