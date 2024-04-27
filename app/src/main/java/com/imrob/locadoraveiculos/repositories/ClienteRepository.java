package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.entities.Cliente;
import com.imrob.locadoraveiculos.repositories.cache.CachedRepository;
import com.imrob.locadoraveiculos.repositories.impl.RobRepository;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

public class ClienteRepository implements RobRepository<Cliente, Long> {
    private final JdbcClient jdbcClient;
    private CachedRepository<Cliente, Long> cachedCliente;

    public ClienteRepository() {
        this.jdbcClient = DatabaseConfig.getConnection();
        this.cachedCliente = new CachedRepository<>(Cliente.class, Long.class);
    }

    /**
     * Recupera todas as entidades armazenadas no banco de dados.
     *
     * @return Uma lista contendo todas as entidades encontradas.
     */
    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = cachedCliente.findAll();
        if (clientes == null) {
            clientes = RobRepository.super.findAll();
            cachedCliente.saveAll(clientes);
        }
        return clientes;
    }

    /**
     * Recupera uma entidade do banco de dados pelo seu identificador único.
     *
     * @param id O identificador único da entidade a ser recuperada.
     * @return A entidade correspondente ao identificador especificado, ou null se não for encontrada.
     */
    @Override
    public Cliente findById(Long id) {
        try {
            Cliente cliente = cachedCliente.findById(id);
            if (cliente == null) {
                cliente = RobRepository.super.findById(id);
                cachedCliente.save(cliente);
            }
            return cliente;
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel encontrar o cliente com id " + id, e);
        }
    }

    public Cliente findByCpf(String cpf) {
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

    /**
     * Salva uma nova entidade no banco de dados.
     *
     * @param cliente A entidade a ser salva no banco de dados.
     */
    @Override
    public Long save(Cliente cliente) {
        Long id = RobRepository.super.save(cliente);
        Cliente clienteSalvo = RobRepository.super.findById(id);
        cachedCliente.save(clienteSalvo);
        return id;
    }

    /**
     * Atualiza uma entidade existente no banco de dados.
     *
     * @param cliente A entidade a ser atualizada no banco de dados.
     */
    @Override
    public void update(Cliente cliente) {
        RobRepository.super.update(cliente);
        cachedCliente.update(cliente);
    }

    /**
     * Exclui uma entidade do banco de dados com base no seu identificador único.
     *
     * @param id O identificador único da entidade a ser excluída do banco de dados.
     */
    @Override
    public void delete(Long id) {
        RobRepository.super.delete(id);
        cachedCliente.delete(id);
    }

    @Override
    public JdbcClient getConnection() {
        return jdbcClient;
    }
}
