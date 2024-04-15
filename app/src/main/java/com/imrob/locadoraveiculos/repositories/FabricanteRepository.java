package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.entities.Fabricante;
import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.repositories.cache.CachedRepository;
import com.imrob.locadoraveiculos.repositories.impl.RobRepository;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

public class FabricanteRepository implements RobRepository<Fabricante, Long> {
    private final JdbcClient jdbcClient;
    private final CachedRepository<Fabricante, Long> cachedFabricante;

    public FabricanteRepository() {
        this.jdbcClient = DatabaseConfig.getConnection();
        this.cachedFabricante = new CachedRepository<>(Fabricante.class, Long.class);
    }

    /**
     * Recupera todas as entidades armazenadas no banco de dados.
     *
     * @return Uma lista contendo todas as entidades encontradas.
     */
    @Override
    public List<Fabricante> findAll() {
        List<Fabricante> fabricantes = cachedFabricante.findAll();
        if (fabricantes == null) {
            fabricantes = RobRepository.super.findAll();
            cachedFabricante.saveAll(fabricantes);
        }
        return fabricantes;
    }

    /**
     * Recupera uma entidade do banco de dados pelo seu identificador único.
     *
     * @param id O identificador único da entidade a ser recuperada.
     * @return A entidade correspondente ao identificador especificado, ou null se não for encontrada.
     */
    @Override
    public Fabricante findById(Long id) {
        try {
            Fabricante fabricante = cachedFabricante.findById(id);
            if (fabricante == null) {
                fabricante = RobRepository.super.findById(id);
                cachedFabricante.save(fabricante);
            }
            return fabricante;
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel encontrar o fabricante com id " + id, e);
        }
    }

    /**
     * Salva uma nova entidade no banco de dados.
     *
     * @param fabricante A entidade a ser salva no banco de dados.
     */
    @Override
    public Long save(Fabricante fabricante) {
        Long id = RobRepository.super.save(fabricante);
        Fabricante fabricanteSalvo = RobRepository.super.findById(id);
        cachedFabricante.save(fabricanteSalvo);
        return id;
    }

    /**
     * Atualiza uma entidade existente no banco de dados.
     *
     * @param fabricante A entidade a ser atualizada no banco de dados.
     */
    @Override
    public void update(Fabricante fabricante) {
        RobRepository.super.update(fabricante);
        cachedFabricante.update(fabricante);
    }

    /**
     * Exclui uma entidade do banco de dados com base no seu identificador único.
     *
     * @param id O identificador único da entidade a ser excluída do banco de dados.
     */
    @Override
    public void delete(Long id) {
        RobRepository.super.delete(id);
        cachedFabricante.delete(id);
    }

    @Override
    public JdbcClient getConnection() {
        return jdbcClient;
    }
}
