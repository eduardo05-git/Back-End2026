package com.itb.inf2am.Zeroum.model.services;

import com.itb.inf2am.Zeroum.model.entity.Vaga;
import com.itb.inf2am.Zeroum.model.repository.VagaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VagaServiceTest {
    @Mock VagaRepository repository;
    @InjectMocks VagaService service;

    @Test
    void aprovarAtualizaStatusEGravaVaga() {
        Vaga vaga = new Vaga();
        vaga.setId(7);
        when(repository.findById(7)).thenReturn(Optional.of(vaga));
        when(repository.save(vaga)).thenReturn(vaga);

        Vaga resultado = service.aprovar(7);

        assertThat(resultado.getStatusVaga()).isEqualTo("APROVADA");
        verify(repository).save(vaga);
    }

    @Test
    void aprovarVagaInexistenteRetornaNuloSemGravar() {
        when(repository.findById(99)).thenReturn(Optional.empty());
        assertThat(service.aprovar(99)).isNull();
        verify(repository, never()).save(any());
    }
}
