package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.entities.Modelo;
import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.repositories.cache.CachedRepository;
import com.imrob.locadoraveiculos.repositories.impl.RobRepository;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

public class ModeloRepository implements RobRepository<Modelo, Long> {
    private final JdbcClient jdbcClient;
    private final CachedRepository<Modelo, Long> cachedModelo;

    public ModeloRepository() {
        this.jdbcClient = DatabaseConfig.getConnection();
        this.cachedModelo = new CachedRepository<>(Modelo.class, Long.class);
    }

    /**
     * Recupera todas as entidades armazenadas no banco de dados.
     *
     * @return Uma lista contendo todas as entidades encontradas.
     */
    @Override
    public List<Modelo> findAll() {
        List<Modelo> modelos = cachedModelo.findAll();
        if (modelos == null) {
            modelos = RobRepository.super.findAll();
            cachedModelo.saveAll(modelos);
        }
        return modelos;
    }

    /**
     * Recupera uma entidade do banco de dados pelo seu identificador único.
     *
     * @param id O identificador único da entidade a ser recuperada.
     * @return A entidade correspondente ao identificador especificado, ou null se não for encontrada.
     */
    @Override
    public Modelo findById(Long id) {
        try {
            Modelo modelo = cachedModelo.findById(id);
            if (modelo == null) {
                modelo = RobRepository.super.findById(id);
                cachedModelo.save(modelo);
            }
            return modelo;
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel encontrar o modelo com id " + id, e);
        }
    }

    /**
     * Salva uma nova entidade no banco de dados.
     *
     * @param modelo A entidade a ser salva no banco de dados.
     */
    @Override
    public Long save(Modelo modelo) {
        Long id = RobRepository.super.save(modelo);
        Modelo modeloSalvo = RobRepository.super.findById(id);
        cachedModelo.save(modeloSalvo);
        return id;
    }

    /**
     * Atualiza uma entidade existente no banco de dados.
     *
     * @param modelo A entidade a ser atualizada no banco de dados.
     */
    @Override
    public void update(Modelo modelo) {
        RobRepository.super.update(modelo);
        cachedModelo.update(modelo);
    }

    /**
     * Exclui uma entidade do banco de dados com base no seu identificador único.
     *
     * @param id O identificador único da entidade a ser excluída do banco de dados.
     */
    @Override
    public void delete(Long id) {
        RobRepository.super.delete(id);
        cachedModelo.delete(id);
    }

    @Override
    public JdbcClient getConnection() {
        return jdbcClient;
    }
}
