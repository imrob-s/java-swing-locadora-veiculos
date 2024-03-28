
package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.entities.Fabricante;
import com.imrob.locadoraveiculos.entities.Carro;
import com.imrob.locadoraveiculos.entities.Modelo;
import java.util.List;
import org.springframework.jdbc.core.simple.JdbcClient;

public class CarroRepository {
    private final JdbcClient jdbcClient;

    public CarroRepository() {
        this.jdbcClient = DatabaseConfig.jdbcClient();
    }
    
    public List<Carro> findAll() {
        return jdbcClient
                .sql("SELECT * FROM carro")
                .query(Carro.class)
                .list();
    }
    
    public Carro findBy(Long id) {
    return jdbcClient
        .sql("SELECT id, nome FROM carro WHERE id = :id")
        .param("id", id)
        .query(Carro.class)
        .single();
  }
    
    public void save(Carro carro) {
        String sql = """
                     INSERT INTO carro (fabricante_id, modelo_id, ano, 
                     cor, placa, valorlocacao, disponivel) 
                     VALUES (?,?,?,?,?,?,?)
                     """;
        jdbcClient
          .sql(sql)
          .params(carro.getFabricanteId(), carro.getModeloId(), carro.getAno(),
          carro.getCor(), carro.getPlaca(), carro.getValorlocacao(),
          carro.getDisponivel())
          .update();
    }
    
    public void delete(Long id) {
        jdbcClient.sql("DELETE FROM carro WHERE id = :id")
        .param("id", id).update();
  }
    
    public void update(Carro carro) {
        String sql = """
                     UPDATE carro SET fabricante_id = ?, modelo_id = ?, 
                     ano = ?, cor = ?, placa = ?, valorlocacao = ?,
                     disponivel = ? WHERE id = ?
                     """;
        jdbcClient
          .sql(sql)
          .params(carro.getFabricanteId(), carro.getModeloId(), carro.getAno(),
          carro.getCor(), carro.getPlaca(), carro.getValorlocacao(),
          carro.getDisponivel(), carro.getId())
          .update();
  }
    public List<Carro> findAllBy(Fabricante fabricante){
        String sql = """
                     SELECT * 
                     FROM carro c
                     WHERE fabricante_id = :id
                     """;
        return jdbcClient
                .sql(sql)
                .param("id", fabricante.getId())
                .query(Carro.class)
                .list();
    }
    
    public List<Carro> findAllBy(Modelo modelo){
        String sql = """
                     SELECT * 
                     FROM carro c
                     WHERE modelo_id = :id
                     """;
        return jdbcClient
                .sql(sql)
                .param("id", modelo.getId())
                .query(Carro.class)
                .list();
    }
    
    public String findNomeModeloById (Long id) {
        String sql = """
                     select m.nome
                     from modelo m 
                     where m.id = :id
                     """;
        return jdbcClient
                .sql(sql)
                .param("id", id)
                .query(String.class)
                .single();
    }
    
        public String findNomeFabricanteById (Long id) {
        String sql = """
                     select f.nome
                     from fabricante f 
                     where f.id = :id
                     """;
        return jdbcClient
                .sql(sql)
                .param("id", id)
                .query(String.class)
                .single();
    } 
}
