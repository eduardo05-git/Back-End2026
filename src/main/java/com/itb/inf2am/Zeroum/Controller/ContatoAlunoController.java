package com.itb.inf2am.Zeroum.controller;

import org.springframework.web.bind.annotation.RestController;
import com.itb.inf2am.Zeroum.model.entity.ContatoAluno;
import com.itb.inf2am.Zeroum.model.repository.ContatoAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato-aluno")
public class ContatoAlunoController {

    @Autowired
    private ContatoAlunoRepository contatoAlunoRepository;

    // Listar todos
    @GetMapping
    public List<ContatoAluno> listarTodos() {
        return contatoAlunoRepository.findAll();
    }

    // Buscar por id
    @GetMapping("/{id}")
    public ContatoAluno buscarPorId(@PathVariable Integer id) {
        return contatoAlunoRepository.findById(id).orElse(null);
    }

    // Buscar contatos de um aluno
    @GetMapping("/aluno/{alunoId}")
    public List<ContatoAluno> buscarPorAluno(@PathVariable Integer alunoId) {
        return contatoAlunoRepository.findByAlunoId(alunoId);
    }

    // Criar contato
    @PostMapping
    public ContatoAluno criar(@RequestBody ContatoAluno contatoAluno) {
        return contatoAlunoRepository.save(contatoAluno);
    }

    // Atualizar contato
    @PutMapping("/{id}")
    public ContatoAluno atualizar(@PathVariable Integer id, @RequestBody ContatoAluno contatoAluno) {

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
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        contatoAlunoRepository.deleteById(id);
    }
}