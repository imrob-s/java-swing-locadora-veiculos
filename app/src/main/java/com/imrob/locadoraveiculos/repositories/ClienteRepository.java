package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.entities.Cliente;
import java.util.List;
import org.springframework.jdbc.core.simple.JdbcClient;

public class ClienteRepository {
    private final JdbcClient jdbcClient;

    public ClienteRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    
    public List<Cliente> findAll() {
        return jdbcClient
                .sql("SELECT * FROM cliente")
                .query(Cliente.class)
                .list();
    }
    
    public Cliente findBy(Long id) {
    return jdbcClient
        .sql("SELECT * FROM cliente WHERE id = :id")
        .param("id", id)
        .query(Cliente.class)
        .single();
  }
    
    public Cliente findByCPF (String cpf) {
        String sql = """
                     SELECT * 
                     FROM cliente 
                     WHERE cpf = :cpf
                     """;
        return jdbcClient
                .sql("SELECT * FROM cliente WHERE cpf = :cpf")
                .param("cpf", cpf)
                .query(Cliente.class)
                .single();
    }
    
        public Cliente findByName (String name) {
        String sql = """
                     SELECT * 
                     FROM cliente 
                     WHERE nome = :name
                     """;
        return jdbcClient
                .sql("SELECT * FROM cliente WHERE name LIKE %:name%")
                .param("name", name)
                .query(Cliente.class)
                .single();
        }
    
    public void save(Cliente cliente) {
        String sql = """
                     INSERT INTO cliente (nome, rg, cpf, cnh, cnh_vencimento,
                     email, logradouro, municipio_id, estado_id, telefone) 
                     VALUES (:nome, :rg, :cpf, :cnh, :cnhv, :email, :log,
                     :munid, :estid, :tel)
                     """;
        jdbcClient
          .sql(sql)
          .param("nome", cliente.getNome())
          .param("rg", cliente.getRg())
          .param("cpf", cliente.getCpf())
          .param("cnh", cliente.getCnh())
          .param("cnhv", cliente.getDataVencimentoCNH())
          .param("email", cliente.getEmail())
          .param("log", cliente.getLogradouro())
          .param("munid", cliente.getMunicipioId())
          .param("estid", cliente.getEstadoId())
          .param("tel", cliente.getTelefone())
          .update();
    }
    
    public void delete(Long id) {
        jdbcClient.sql("DELETE FROM cliente WHERE id = :id")
        .param("id", id).update();
  }
    
    public void update(Cliente cliente) {
        String sql = """
                     UPDATE cliente SET
                     nome = :nome,
                     rg = :rg,
                     cpf = :cpf,
                     cnh = :cnh,
                     cnh_vencimento = :cnhv,
                     email = :email,
                     logradouro = :log,
                     municipio_id = :munid,
                     estado_id = :estid,
                     telefone = :tel
                     """;
        jdbcClient
          .sql(sql)
          .param("nome", cliente.getNome())
          .param("rg", cliente.getRg())
          .param("cpf", cliente.getCpf())
          .param("cnh", cliente.getCnh())
          .param("cnhv", cliente.getDataVencimentoCNH())
          .param("email", cliente.getEmail())
          .param("log", cliente.getLogradouro())
          .param("munid", cliente.getMunicipioId())
          .param("estid", cliente.getEstadoId())
          .param("tel", cliente.getTelefone())
          .update();
  }
    
}
