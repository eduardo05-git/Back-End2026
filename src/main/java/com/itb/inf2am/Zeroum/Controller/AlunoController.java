package com.itb.inf2am.Zeroum.Controller;

import com.itb.inf2am.Zeroum.model.entity.Aluno;
import com.itb.inf2am.Zeroum.model.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> findAll() {
        return alunoService.findAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Aluno create(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Aluno aluno) {
        Aluno atualizado = alunoService.atualizar(id, aluno);
        if (atualizado != null) return ResponseEntity.ok(atualizado);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
    }
}