package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.entities.Seguradora;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

public class SeguradoraRepository {
    private final JdbcClient jdbcClient;

    public SeguradoraRepository() {
        this.jdbcClient = DatabaseConfig.jdbcClient();
    }

    public List<Seguradora> findAll() {
        return jdbcClient
                .sql("SELECT * FROM seguradora")
                .query(Seguradora.class)
                .list();
    }

    public Seguradora findBy(Long id) {
        return jdbcClient
                .sql("SELECT * FROM seguradora WHERE id = :id")
                .param("id", id)
                .query(Seguradora.class)
                .single();
    }

    public Seguradora findByName (String name) {
        String sql = """
                     SELECT *
                     FROM seguradora
                     WHERE nome = :name
                     """;
        return jdbcClient
                .sql("SELECT * FROM seguradora WHERE nome LIKE %:name%")
                .param("name", name)
                .query(Seguradora.class)
                .single();
    }

    public void save(Seguradora seguradora) {
        String sql = """
                     INSERT INTO seguradora (nome, cnpj, email, valor, municipio_id,
                     estado_id_id, telefone)
                     VALUES (:nome, :cnpj, :email, :valor, :munid, :estid, :tel )
                     """;
        jdbcClient
                .sql(sql)
                .param("nome", seguradora.getNome())
                .param("cnpj", seguradora.getCnpj())
                .param("email", seguradora.getEmail())
                .param("valor", seguradora.getValor())
                .param("munid", seguradora.getMunicipioId())
                .param("estid", seguradora.getEstadoId())
                .param("tel", seguradora.getTelefone())
                .update();
    }

    public void delete(Long id) {
        jdbcClient.sql("DELETE FROM seguradora WHERE id = :id")
                .param("id", id).update();
    }

    public void update(Seguradora seguradora) {
        String sql = """
                     UPDATE cliente SET
                     nome = :nome,
                     cnpj = :cnpj,
                     email = :email,
                     valor = :valor,
                     municipio_id = :munid,
                     estado_id = :estid,
                     telefone = :tel
                     """;
        jdbcClient
                .sql(sql)
                .param("nome", seguradora.getNome())
                .param("cnpj", seguradora.getCnpj())
                .param("email", seguradora.getEmail())
                .param("valor", seguradora.getValor())
                .param("munid", seguradora.getMunicipioId())
                .param("estid", seguradora.getEstadoId())
                .param("tel", seguradora.getTelefone())
                .update();
    }
}
