package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.entities.Seguradora;
import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.repositories.impl.RobRepository;
import org.springframework.jdbc.core.simple.JdbcClient;

public class SeguradoraRepository implements RobRepository<Seguradora, Long> {
    @Override
    public JdbcClient getConnection() {
        return DatabaseConfig.jdbcClient();
    }
}
