package com.imrob.locadoraveiculos.config;

import io.github.cdimascio.dotenv.Dotenv;
import javax.sql.DataSource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @Author Rob Silva
 */
public class DatabaseConfig {

    private static DatabaseConfig instance;
    private static DataSource dataSource;
    private static JdbcClient jdbcClient;

    private DatabaseConfig() {
        // Construtor privado para evitar instanciação externa (padrão Singleton)
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("JDBC_URL", "jdbc:postgresql://localhost:5432/postgres");
        String username = dotenv.get("DB_USER", "postgres");
        String password = dotenv.get("DB_PASSWORD", "postgres");

        DriverManagerDataSource dms = new DriverManagerDataSource();
        dms.setDriverClassName("org.postgresql.Driver");
        dms.setUrl(url);
        dms.setUsername(username);
        dms.setPassword(password);
        dataSource = dms;
    }

    public static DatabaseConfig getInstance() {
        if (instance == null) {
            synchronized (DatabaseConfig.class) {
                if (instance == null) {
                    instance = new DatabaseConfig();
                }
            }
        }
        return instance;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public static JdbcClient getConnection() {
        if (jdbcClient == null) {
            jdbcClient = JdbcClient.create(getInstance().getDataSource());
        }
        return jdbcClient;
    }
}
