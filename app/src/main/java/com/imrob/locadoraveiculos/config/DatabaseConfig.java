package com.imrob.locadoraveiculos.config;

import javax.sql.DataSource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Rob
 */
public class DatabaseConfig {

 public static DataSource createDataSource() {
        String url = "jdbc:postgresql://***REMOVED***/robson_locadora";
        String username = "postgres";
        String password = "***REMOVED***";

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    public static JdbcClient createJdbcClient() {
        return JdbcClient.create(createDataSource());
    }
    
}
