package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.entities.Modelo;
import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.repositories.impl.RobRepository;
import org.springframework.jdbc.core.simple.JdbcClient;

public class ModeloRepository implements RobRepository<Modelo, Long> {
    @Override
    public JdbcClient getConnection() {
        return DatabaseConfig.jdbcClient();
    }
}
