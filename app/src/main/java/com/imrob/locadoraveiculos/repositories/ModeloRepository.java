
package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.entities.Modelo;
import java.util.List;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class ModeloRepository {
    private final JdbcClient jdbcClient;

    public ModeloRepository() {
        this.jdbcClient = DatabaseConfig.jdbcClient();
    }
    
    public List<Modelo> findAll() {
        return jdbcClient
                .sql("SELECT * FROM modelo")
                .query(Modelo.class)
                .list();
    }
    
    public Modelo findBy(Long id) {
    return jdbcClient
        .sql("SELECT id, nome FROM modelo WHERE id = :id")
        .param("id", id)
        .query(Modelo.class)
        .single();
  }
    
    public Long save(Modelo modelo) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = """
                     INSERT INTO modelo (nome, fabricante_id) 
                     VALUES (:nome, :fabricanteId)
                     """;
        jdbcClient
          .sql(sql)
          .param("nome", modelo.getNome())
          .param("fabricanteId", modelo.getFabricanteId())
          .update(keyHolder, "id");
        
        return keyHolder.getKey().longValue();
    }
    
    public void delete(Long id) {
        jdbcClient.sql("DELETE FROM product WHERE id = :id")
        .param("id", id).update();
  }
    
    public void update(Modelo modelo) {
        jdbcClient
        .sql("UPDATE modelo SET nome = :nome WHERE id = :id")
        .param("id", modelo.getId())
        .param("nome", modelo.getNome())
        .update();
  }
    public List<Modelo> findByFabricanteId(Long id){
        String sql = """
                     SELECT * 
                     FROM modelo m
                     WHERE m.fabricante_id = :id
                     """;
        return jdbcClient
                .sql(sql)
                .param("id", id)
                .query(Modelo.class)
                .list();
    }
    
}
