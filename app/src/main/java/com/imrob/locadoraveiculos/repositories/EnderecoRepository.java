package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.entities.Endereco;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;

public class EnderecoRepository {
    private final JdbcClient jdbcClient;

    public EnderecoRepository() {
        this.jdbcClient = DatabaseConfig.jdbcClient();
    }


    public Endereco findBy(Long id) {
        return jdbcClient
                .sql("SELECT * FROM endereco WHERE id = :id")
                .param("id", id)
                .query(Endereco.class)
                .single();
    }

    public Long save(Endereco endereco) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = """
                INSERT INTO cliente_endereco (cep, rua, numero, bairro, cidade, estado) 
                VALUES (:cep, :rua, :numero, :bairro, :cidade, :estado)
                """;
        jdbcClient
                .sql(sql)
                .param("cep", endereco.getCep())
                .param("rua", endereco.getRua())
                .param("numero", endereco.getNumero())
                .param("bairro", endereco.getBairro())
                .param("cidade", endereco.getCidade())
                .param("estado", endereco.getEstado())
                .update(keyHolder, "id");

        return keyHolder.getKey().longValue();
    }

    public void delete(Long id) {
        String sql = "DELETE FROM endereco WHERE id = :id";
        jdbcClient
                .sql(sql)
                .param("id", id)
                .update();
    }

    public void update(Endereco endereco) {
        String sql = """
                UPDATE endereco SET cep = :cep, rua = :rua, numero = :numero, 
                bairro = :bairro, cidade = :cidade, estado = :estado WHERE id = :id
                """;
        jdbcClient
                .sql(sql)
                .param("cep", endereco.getCep())
                .param("rua", endereco.getRua())
                .param("numero", endereco.getNumero())
                .param("bairro", endereco.getBairro())
                .param("cidade", endereco.getCidade())
                .param("estado", endereco.getEstado())
                .param("id", endereco.getId())
                .update();
    }
}
