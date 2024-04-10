package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.entities.Fabricante;
import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.repositories.impl.RobRepository;
import org.springframework.jdbc.core.simple.JdbcClient;

public class FabricanteRepository implements RobRepository<Fabricante, Long> {
    @Override
    public JdbcClient getConnection() {
        return DatabaseConfig.jdbcClient();
    }
}
