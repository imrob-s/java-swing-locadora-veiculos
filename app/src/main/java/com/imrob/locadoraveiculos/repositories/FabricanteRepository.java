/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.entities.Fabricante;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.simple.JdbcClient;

/**
 *
 * @author Rob
 */
public class FabricanteRepository {
    private final JdbcClient jdbcClient;

    public FabricanteRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    
    public List<Fabricante> findAll() {
        return jdbcClient
                .sql("SELECT * FROM fabricante")
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
