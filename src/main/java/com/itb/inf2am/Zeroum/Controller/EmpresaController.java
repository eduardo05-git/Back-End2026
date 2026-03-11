package com.itb.inf2am.Zeroum.Controller;

import com.itb.inf2am.Zeroum.model.entity.Empresa;
import com.itb.inf2am.Zeroum.model.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> findAll() {
        return empresaService.findAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Empresa create(@RequestBody Empresa empresa) {
        return empresaService.save(empresa);
    }
}