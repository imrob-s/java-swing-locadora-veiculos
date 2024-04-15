package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.entities.Seguradora;
import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.repositories.cache.CachedRepository;
import com.imrob.locadoraveiculos.repositories.impl.RobRepository;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

public class SeguradoraRepository implements RobRepository<Seguradora, Long> {
    private final JdbcClient jdbcClient;
    private final CachedRepository<Seguradora, Long> cachedSeguradora;

    public SeguradoraRepository() {
        this.jdbcClient = DatabaseConfig.getConnection();
        this.cachedSeguradora = new CachedRepository<>(Seguradora.class, Long.class);
    }

    /**
     * Recupera todas as entidades armazenadas no banco de dados.
     *
     * @return Uma lista contendo todas as entidades encontradas.
     */
    @Override
    public List<Seguradora> findAll() {
        List<Seguradora> seguradoras = cachedSeguradora.findAll();
        if (seguradoras == null) {
            seguradoras = RobRepository.super.findAll();
            cachedSeguradora.saveAll(seguradoras);
        }
        return seguradoras;
    }

    /**
     * Recupera uma entidade do banco de dados pelo seu identificador único.
     *
     * @param id O identificador único da entidade a ser recuperada.
     * @return A entidade correspondente ao identificador especificado, ou null se não for encontrada.
     */
    @Override
    public Seguradora findById(Long id) {
        try {
            Seguradora seguradora = cachedSeguradora.findById(id);
            if (seguradora == null) {
                seguradora = RobRepository.super.findById(id);
                cachedSeguradora.save(seguradora);
            }
            return seguradora;
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel encontrar a seguradora com id " + id, e);
        }
    }

    /**
     * Salva uma nova entidade no banco de dados.
     *
     * @param seguradora A entidade a ser salva no banco de dados.
     */
    @Override
    public Long save(Seguradora seguradora) {
        Long id = RobRepository.super.save(seguradora);
        Seguradora seguradoraSalva = RobRepository.super.findById(id);
        cachedSeguradora.save(seguradoraSalva);
        return id;
    }

    /**
     * Atualiza uma entidade existente no banco de dados.
     *
     * @param seguradora A entidade a ser atualizada no banco de dados.
     */
    @Override
    public void update(Seguradora seguradora) {
        RobRepository.super.update(seguradora);
        cachedSeguradora.update(seguradora);
    }

    /**
     * Exclui uma entidade do banco de dados com base no seu identificador único.
     *
     * @param id O identificador único da entidade a ser excluída do banco de dados.
     */
    @Override
    public void delete(Long id) {
        RobRepository.super.delete(id);
        cachedSeguradora.delete(id);
    }

    @Override
    public JdbcClient getConnection() {
        return jdbcClient;
    }
}
