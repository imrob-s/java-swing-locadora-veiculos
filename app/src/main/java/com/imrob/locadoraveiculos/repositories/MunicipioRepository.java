package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.entities.Municipio;
import org.springframework.jdbc.core.simple.JdbcClient;

public class MunicipioRepository {
    private final JdbcClient jdbcClient;

    public MunicipioRepository() {
        this.jdbcClient = DatabaseConfig.jdbcClient();
    }

    public Municipio findByName(String nome, String estadoSigla) {
        String sql = """
                SELECT m.id, m.nome, m.estado_id, e.nome estado_nome
                FROM municipio m
                INNER JOIN estado e ON m.estado_id = e.id
                WHERE m.nome = upper(:nome) and e.sigla = upper(:estado);
                """;
        return jdbcClient
                .sql(sql)
                .param("nome", nome)
                .param("estado", estadoSigla)
                .query(Municipio.class)
                .single();
    }

    public Municipio findById (Long id) {
        String sql = """
                SELECT m.id, m.nome, m.estado_id, e.nome estado_nome
                FROM municipio m
                INNER JOIN estado e ON m.estado_id = e.id
                WHERE m.id = :id
                """;
        return jdbcClient
                .sql(sql)
                .param("id", id)
                .query(Municipio.class)
                .single();
    }
}

