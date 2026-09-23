package com.itb.inf2am.Zeroum.connection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

/** Opt-in: usa o perfil selecionado por SPRING_PROFILES_ACTIVE e executa somente SELECT 1. */
@SpringBootTest
@EnabledIfEnvironmentVariable(named = "RUN_DB_CONNECTION_TESTS", matches = "(?i)true")
class DatabaseConnectionSmokeTest {
    @Autowired JdbcTemplate jdbcTemplate;

    @Test
    void executaConsultaNaConexaoConfigurada() {
        assertThat(jdbcTemplate.queryForObject("SELECT 1", Integer.class)).isEqualTo(1);
    }
}
