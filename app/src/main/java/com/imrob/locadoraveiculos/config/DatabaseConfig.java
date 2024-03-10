package com.imrob.locadoraveiculos.config;

import io.github.cdimascio.dotenv.Dotenv;
import javax.sql.DataSource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Rob
 */
public class DatabaseConfig {

 public static DataSource dataSource() {
     /* Obs: Crie um arquivo ".env" na raiz do projeto e coloque os valores
     das variaveis de ambiente dentro dele.
     */
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("JDBC_URL", "jdbc:postgresql://localhost:5432/postgres");
        String username = dotenv.get("DB_USER", "postgres");
        String password = dotenv.get("DB_PASSWORD", "postgres");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    public static JdbcClient jdbcClient() {
        return JdbcClient.create(dataSource());
    }
    
}
