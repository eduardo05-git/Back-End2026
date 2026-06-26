package com.itb.inf2am.Zeroum.model.services;

import com.itb.inf2am.Zeroum.model.entity.Aluno;
import com.itb.inf2am.Zeroum.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    // Listar todos os alunos
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    // Salvar um aluno no banco
    public Aluno save(Aluno aluno) {
        aluno.setStatusAluno("ATIVO");
        aluno.setDataCadastro(LocalDateTime.now().withNano(0));
        return alunoRepository.save(aluno);
    }

    public Aluno findById(Integer id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public Aluno atualizar(Integer id, Aluno dadosNovos) {
        Aluno aluno = findById(id);
        if (aluno == null) return null;

        if (dadosNovos.getBio() != null) aluno.setBio(dadosNovos.getBio());
        if (dadosNovos.getHabilidades() != null) aluno.setHabilidades(dadosNovos.getHabilidades());
        if (dadosNovos.getLinkPortfolio() != null) aluno.setLinkPortfolio(dadosNovos.getLinkPortfolio());
        if (dadosNovos.getLinkCurriculo() != null) aluno.setLinkCurriculo(dadosNovos.getLinkCurriculo());

        return alunoRepository.save(aluno);
    }
}