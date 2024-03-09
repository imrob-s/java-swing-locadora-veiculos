/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.entities.Fabricante;
import com.imrob.locadoraveiculos.entities.Modelo;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.simple.JdbcClient;

/**
 *
 * @author Rob
 */
public class ModeloRepository {
    private final JdbcClient jdbcClient;

    public ModeloRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    
    public List<Modelo> findAll() {
        return jdbcClient
                .sql("SELECT * FROM modelo")
                .query(Modelo.class)
                .list();
    }
    
    public Optional<Modelo> findBy(Long id) {
    return jdbcClient
        .sql("SELECT id, nome FROM modelo WHERE id = :id")
        .param("id", id)
        .query(Modelo.class)
        .optional();
  }
    
    public void create(Modelo modelo) {
        jdbcClient
          .sql("INSERT INTO product (id, description) VALUES (:id, :nome)")
          .param("id", modelo.getId())
          .param("nome", modelo.getNome())
          .update();
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
    public List<Modelo> findByFabricante(){
        String sql = """
                     SELECT * 
                     FROM modelo m
                     INNER JOIN fabricante f
                     WHERE m.id = :id
                     """;
        return jdbcClient
                .sql(sql)
                .query(Modelo.class)
                .list();
    }
}
