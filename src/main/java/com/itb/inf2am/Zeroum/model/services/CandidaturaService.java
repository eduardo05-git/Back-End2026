package com.itb.inf2am.Zeroum.model.services;

import com.itb.inf2am.Zeroum.model.entity.Candidatura;
import com.itb.inf2am.Zeroum.model.repository.CandidaturaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CandidaturaService {

    @Autowired
    private CandidaturaRepository candidaturaRepository;

    // Listar todas
    public List<Candidatura> findAll() {
        return candidaturaRepository.findAll();
    }

    // Buscar por ID
    public Candidatura findById(Integer id) {
        return candidaturaRepository.findById(id).orElse(null);
    }

    // Buscar por aluno
    public List<Candidatura> findByAlunoId(Integer alunoId) {
        return candidaturaRepository.findByAlunoId(alunoId);
    }

    // Buscar por vaga
    public List<Candidatura> findByVagaId(Integer vagaId) {
        return candidaturaRepository.findByVagaId(vagaId);
    }

    // Criar candidatura
    public Candidatura save(Candidatura candidatura) {

        candidatura.setDataCadastro(LocalDateTime.now().withNano(0));
        candidatura.setStatusCandidatura("ENVIADO");

        return candidaturaRepository.save(candidatura);
    }

    // Atualizar
    public Candidatura update(Integer id, Candidatura candidatura) {

        Candidatura candidaturaExistente = candidaturaRepository.findById(id).orElse(null);

        if (candidaturaExistente != null) {

            candidaturaExistente.setAlunoId(candidatura.getAlunoId());
            candidaturaExistente.setVagaId(candidatura.getVagaId());
            candidaturaExistente.setStatusCandidatura(candidatura.getStatusCandidatura());

            return candidaturaRepository.save(candidaturaExistente);
        }

        return null;
    }

    // Deletar
    public void delete(Integer id) {
        candidaturaRepository.deleteById(id);
    }
}