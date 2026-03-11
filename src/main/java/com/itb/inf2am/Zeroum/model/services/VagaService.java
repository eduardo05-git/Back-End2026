package com.itb.inf2am.Zeroum.model.services;

import com.itb.inf2am.Zeroum.model.entity.Vaga;
import com.itb.inf2am.Zeroum.model.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    // Listar todas as vagas
    public List<Vaga> findAll() {
        return vagaRepository.findAll();
    }

    // Salvar vaga
    public Vaga save(Vaga vaga) {
        vaga.setStatusVaga("ATIVO");
        vaga.setDataCadastro(LocalDateTime.now().withNano(0));
        return vagaRepository.save(vaga);
    }
}