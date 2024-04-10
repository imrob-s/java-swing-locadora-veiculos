package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.entities.Locacao;
import com.imrob.locadoraveiculos.repositories.impl.RobRepository;
import org.springframework.jdbc.core.simple.JdbcClient;

public class LocacaoRepository implements RobRepository<Locacao, Long> {
    @Override
    public JdbcClient getConnection() {
        return DatabaseConfig.jdbcClient();
    }
}
