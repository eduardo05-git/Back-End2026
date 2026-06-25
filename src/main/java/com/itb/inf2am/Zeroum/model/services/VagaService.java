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

    public List<Vaga> findAll() {
        return vagaRepository.findAll();
    }

    public List<Vaga> findByStatus(String status) {
        return vagaRepository.findByStatusVaga(status);
    }

    public List<Vaga> findByEmpresaId(Integer empresaId) {
        return vagaRepository.findByEmpresaId(empresaId);
    }

    public Vaga findById(Integer id) {
        return vagaRepository.findById(id).orElse(null);
    }

    public Vaga save(Vaga vaga) {
        vaga.setStatusVaga("PENDENTE");
        vaga.setMotivoRecusa(null);
        vaga.setDataCadastro(LocalDateTime.now().withNano(0));
        return vagaRepository.save(vaga);
    }

    public Vaga atualizar(Integer id, Vaga dadosNovos) {
        Vaga vaga = findById(id);
        if (vaga == null) return null;

        if (dadosNovos.getNome() != null) vaga.setNome(dadosNovos.getNome());
        if (dadosNovos.getDescricao() != null) vaga.setDescricao(dadosNovos.getDescricao());
        if (dadosNovos.getRequisitos() != null) vaga.setRequisitos(dadosNovos.getRequisitos());
        if (dadosNovos.getModalidade() != null) vaga.setModalidade(dadosNovos.getModalidade());
        if (dadosNovos.getArea() != null) vaga.setArea(dadosNovos.getArea());
        if (dadosNovos.getCidade() != null) vaga.setCidade(dadosNovos.getCidade());
        if (dadosNovos.getBairro() != null) vaga.setBairro(dadosNovos.getBairro());
        if (dadosNovos.getCargaHoraria() != null) vaga.setCargaHoraria(dadosNovos.getCargaHoraria());
        if (dadosNovos.getSalario() != null) vaga.setSalario(dadosNovos.getSalario());

        vaga.setStatusVaga("PENDENTE");
        vaga.setMotivoRecusa(null);

        return vagaRepository.save(vaga);
    }

    public Vaga aprovar(Integer id) {
        Vaga vaga = findById(id);
        if (vaga == null) return null;
        vaga.setStatusVaga("APROVADA");
        vaga.setMotivoRecusa(null);
        return vagaRepository.save(vaga);
    }

    public Vaga recusar(Integer id, String motivo) {
        Vaga vaga = findById(id);
        if (vaga == null) return null;
        vaga.setStatusVaga("RECUSADA");
        vaga.setMotivoRecusa(motivo);
        return vagaRepository.save(vaga);
    }
}