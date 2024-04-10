
package com.imrob.locadoraveiculos.repositories.deprecated;

import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.entities.Fabricante;
import java.util.List;
import org.springframework.jdbc.core.simple.JdbcClient;

public class FabricanteRepository {
    private final JdbcClient jdbcClient;

    public FabricanteRepository() {
        this.jdbcClient = DatabaseConfig.jdbcClient();
    }
    
    public List<Fabricante> findAll() {
        return jdbcClient
                .sql("SELECT * FROM fabricante ORDER BY nome ASC")
                .query(Fabricante.class)
                .list();
    }
    
    public Fabricante findBy(Long id) {
    return jdbcClient
        .sql("SELECT id, nome FROM fabricante WHERE id = :id")
        .param("id", id)
        .query(Fabricante.class)
        .single();
  }
    
    public void save(Fabricante fabricante) {
        jdbcClient
          .sql("INSERT INTO fabricante (nome) VALUES (:nome)")
          .param("nome", fabricante.getNome())
          .update();
    }
    
    public void delete(Long id) {
        jdbcClient.sql("DELETE FROM product WHERE id = :id")
        .param("id", id).update();
  }
    
    public void update(Fabricante fabricante) {
        jdbcClient
        .sql("UPDATE fabricante SET nome = :nome WHERE id = :id")
        .param("id", fabricante.getId())
        .param("nome", fabricante.getNome())
        .update();
  }
    
}
