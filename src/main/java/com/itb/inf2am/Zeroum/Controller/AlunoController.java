package com.itb.inf2am.Zeroum.Controller;

import com.itb.inf2am.Zeroum.model.entity.Aluno;
import com.itb.inf2am.Zeroum.model.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
}