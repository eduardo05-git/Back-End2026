package com.itb.inf2am.Zeroum.Controller;

import com.itb.inf2am.Zeroum.model.entity.Candidatura;
import com.itb.inf2am.Zeroum.model.services.CandidaturaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidatura")
public class CandidaturaController {

    @Autowired
    private CandidaturaService candidaturaService;

    @GetMapping
    public List<Candidatura> listarTodas() {
        return candidaturaService.findAll();
    }

    @GetMapping("/{id}")
    public Candidatura buscarPorId(@PathVariable Integer id) {
        return candidaturaService.findById(id);
    }

    @GetMapping("/aluno/{alunoId}")
    public List<Candidatura> buscarPorAluno(@PathVariable Integer alunoId) {
        return candidaturaService.findByAlunoId(alunoId);
    }

    @GetMapping("/vaga/{vagaId}")
    public List<Candidatura> buscarPorVaga(@PathVariable Integer vagaId) {
        return candidaturaService.findByVagaId(vagaId);
    }

    @PostMapping
    public Candidatura criar(@RequestBody Candidatura candidatura) {
        return candidaturaService.save(candidatura);
    }

    @PutMapping("/{id}")
    public Candidatura atualizar(@PathVariable Integer id, @RequestBody Candidatura candidatura) {
        return candidaturaService.update(id, candidatura);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        candidaturaService.delete(id);
    }
}