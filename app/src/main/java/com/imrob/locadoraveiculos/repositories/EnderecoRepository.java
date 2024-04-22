package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.entities.Endereco;
import com.imrob.locadoraveiculos.repositories.cache.CachedRepository;
import com.imrob.locadoraveiculos.repositories.impl.RobRepository;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

public class EnderecoRepository implements RobRepository<Endereco, Long> {
    private final JdbcClient jdbcClient;
    private CachedRepository<Endereco, Long> cachedEndereco;

    public EnderecoRepository() {
        this.jdbcClient = DatabaseConfig.getConnection();
        this.cachedEndereco = new CachedRepository<>(Endereco.class, Long.class);
    }

    /**
     * Recupera todas as entidades armazenadas no banco de dados.
     *
     * @return Uma lista contendo todas as entidades encontradas.
     */
    @Override
    public List<Endereco> findAll() {
        List<Endereco> enderecos = cachedEndereco.findAll();
        if (enderecos == null) {
            enderecos = RobRepository.super.findAll();
            cachedEndereco.saveAll(enderecos);
        }
        return enderecos;
    }

    /**
     * Recupera uma entidade do banco de dados pelo seu identificador unico.
     *
     * @param id O identificador unico da entidade a ser recuperada.
     * @return A entidade correspondente ao identificador especificado, ou null se nao for encontrada.
     */
    @Override
    public Endereco findById(Long id) {
        try {
            Endereco endereco = cachedEndereco.findById(id);
            if (endereco == null) {
                endereco = RobRepository.super.findById(id);
                cachedEndereco.save(endereco);
            }
            return endereco;
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel encontrar o endereco com id " + id, e);
        }
    }

    /**
     * Salva uma nova entidade no banco de dados.
     *
     * @param endereco A entidade a ser salva no banco de dados.
     */
    @Override
    public Long save(Endereco endereco) {
        Long id = RobRepository.super.save(endereco);
        Endereco enderecoSalvo = RobRepository.super.findById(id);
        cachedEndereco.save(enderecoSalvo);
        return id;
    }

    /**
     * Atualiza uma entidade existente no banco de dados.
     *
     * @param endereco A entidade a ser atualizada no banco de dados.
     */
    @Override
    public void update(Endereco endereco) {
        RobRepository.super.update(endereco);
        cachedEndereco.update(endereco);
    }

    /**
     * Exclui uma entidade do banco de dados com base no seu identificador único.
     *
     * @param id O identificador único da entidade a ser excluída do banco de dados.
     */
    @Override
    public void delete(Long id) {
        RobRepository.super.delete(id);
        cachedEndereco.delete(id);
    }

    @Override
    public JdbcClient getConnection() {
        return jdbcClient;
    }
}
