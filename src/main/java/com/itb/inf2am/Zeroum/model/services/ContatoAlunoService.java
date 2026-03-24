package com.itb.inf2am.Zeroum.model.services;

import com.itb.inf2am.Zeroum.model.entity.ContatoAluno;
import com.itb.inf2am.Zeroum.model.repository.ContatoAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoAlunoService {

    @Autowired
    private ContatoAlunoRepository contatoAlunoRepository;

    // Listar todos os contatos
    public List<ContatoAluno> findAll() {
        return contatoAlunoRepository.findAll();
    }

    // Buscar por ID
    public ContatoAluno findById(Integer id) {
        return contatoAlunoRepository.findById(id).orElse(null);
    }

    // Buscar contatos por aluno
    public List<ContatoAluno> findByAlunoId(Integer alunoId) {
        return contatoAlunoRepository.findByAlunoId(alunoId);
    }

    // Salvar contato
    public ContatoAluno save(ContatoAluno contatoAluno) {
        return contatoAlunoRepository.save(contatoAluno);
    }

    // Atualizar contato
    public ContatoAluno update(Integer id, ContatoAluno contatoAluno) {

        ContatoAluno contatoExistente = contatoAlunoRepository.findById(id).orElse(null);

        if (contatoExistente != null) {

            contatoExistente.setAlunoId(contatoAluno.getAlunoId());
            contatoExistente.setNomeContato(contatoAluno.getNomeContato());
            contatoExistente.setLink(contatoAluno.getLink());

            return contatoAlunoRepository.save(contatoExistente);
        }

        return null;
    }

    // Deletar contato
    public void delete(Integer id) {
        contatoAlunoRepository.deleteById(id);
    }
}