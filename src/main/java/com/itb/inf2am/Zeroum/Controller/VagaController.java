package com.itb.inf2am.Zeroum.Controller;

import com.itb.inf2am.Zeroum.model.entity.Vaga;
import com.itb.inf2am.Zeroum.model.services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/vaga")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @GetMapping
    public List<Vaga> findAll(@RequestParam(required = false) String status,
                              @RequestParam(required = false) Integer empresaId) {
        if (status != null) return vagaService.findByStatus(status);
        if (empresaId != null) return vagaService.findByEmpresaId(empresaId);
        return vagaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Vaga vaga = vagaService.findById(id);
        if (vaga != null) return ResponseEntity.ok(vaga);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada");
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Vaga create(@RequestBody Vaga vaga) {
        return vagaService.save(vaga);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Vaga vaga) {
        Vaga atualizada = vagaService.atualizar(id, vaga);
        if (atualizada != null) return ResponseEntity.ok(atualizada);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada");
    }

    @PutMapping("/{id}/aprovar")
    public ResponseEntity<?> aprovar(@PathVariable Integer id) {
        Vaga vaga = vagaService.aprovar(id);
        if (vaga != null) return ResponseEntity.ok(vaga);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada");
    }

    @PutMapping("/{id}/recusar")
    public ResponseEntity<?> recusar(@PathVariable Integer id, @RequestBody Map<String, String> body) {
        String motivo = body.get("motivoRecusa");
        if (motivo == null || motivo.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("O motivo da recusa é obrigatório");
        }
        Vaga vaga = vagaService.recusar(id, motivo);
        if (vaga != null) return ResponseEntity.ok(vaga);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        boolean removida = vagaService.deletar(id);
        if (removida) return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada");
    }
}