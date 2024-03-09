/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.entities.Fabricante;
import java.util.List;
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
}
