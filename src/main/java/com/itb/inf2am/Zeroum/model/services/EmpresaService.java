package com.itb.inf2am.Zeroum.model.services;

import com.itb.inf2am.Zeroum.model.entity.Empresa;
import com.itb.inf2am.Zeroum.model.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    // Listar todas as empresas
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    // Salvar empresa
    public Empresa save(Empresa empresa) {
        empresa.setStatusEmpresa("ATIVO");
        empresa.setDataCadastro(LocalDateTime.now().withNano(0));
        return empresaRepository.save(empresa);
    }
}