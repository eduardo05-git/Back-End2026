package com.itb.inf2am.Zeroum.repository;

import com.itb.inf2am.Zeroum.model.entity.Vaga;
import com.itb.inf2am.Zeroum.model.repository.VagaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class RepositoryIntegrationTest {
    @Autowired VagaRepository repository;

    @Test
    void persisteEConsultaVagaPorStatus() {
        Vaga vaga = new Vaga();
        vaga.setEmpresaId(1);
        vaga.setNome("Estágio backend");
        vaga.setDescricao("Desenvolvimento de APIs");
        vaga.setArea("Tecnologia");
        vaga.setDataCadastro(java.time.LocalDateTime.now());
        vaga.setStatusVaga("Pendente");
        repository.saveAndFlush(vaga);
        assertThat(repository.findByStatusVaga("Pendente"))
                .extracting(Vaga::getNome).contains("Estágio backend");
    }
}
