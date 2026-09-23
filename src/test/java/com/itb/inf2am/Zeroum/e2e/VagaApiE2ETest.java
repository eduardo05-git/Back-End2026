package com.itb.inf2am.Zeroum.e2e;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itb.inf2am.Zeroum.model.entity.Vaga;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class VagaApiE2ETest {
    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;

    @Test
    void fluxoDeCadastroAprovacaoEConsulta() throws Exception {
        Vaga vaga = new Vaga();
        vaga.setEmpresaId(10);
        vaga.setNome("Estágio E2E");
        vaga.setDescricao("Vaga criada pelo teste de ponta a ponta");
        vaga.setArea("Tecnologia");

        String body = mockMvc.perform(post("/api/v1/vaga")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vaga)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusVaga").value("PENDENTE"))
                .andReturn().getResponse().getContentAsString();
        int id = objectMapper.readTree(body).get("id").asInt();

        mockMvc.perform(put("/api/v1/vaga/{id}/aprovar", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusVaga").value("APROVADA"));
        mockMvc.perform(get("/api/v1/vaga/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Estágio E2E"));
    }

    @Test
    void recusaSemMotivoRetornaBadRequest() throws Exception {
        mockMvc.perform(put("/api/v1/vaga/999/recusar")
                        .contentType(MediaType.APPLICATION_JSON).content("{}"))
                .andExpect(status().isBadRequest());
    }
}
