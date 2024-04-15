package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.entities.Carro;
import com.imrob.locadoraveiculos.repositories.cache.CachedRepository;
import com.imrob.locadoraveiculos.repositories.impl.RobRepository;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

public class CarroRepository implements RobRepository<Carro, Long> {
    private final JdbcClient jdbcClient;
    private final CachedRepository<Carro, Long> cachedCarro;

    public CarroRepository() {
        this.jdbcClient = DatabaseConfig.getConnection();
        this.cachedCarro = new CachedRepository<>(Carro.class, Long.class);
    }

    /**
     * Recupera todas as entidades armazenadas no banco de dados.
     *
     * @return Uma lista contendo todas as entidades encontradas.
     */
    @Override
    public List<Carro> findAll() {
        List<Carro> carros = cachedCarro.findAll();
        if (carros == null) {
            carros = RobRepository.super.findAll();
            System.out.println("peguei do banco de dados");
            cachedCarro.saveAll(carros);
        }
        return carros;
    }

    /**
     * Recupera uma entidade do banco de dados pelo seu identificador único.
     *
     * @param id O identificador único da entidade a ser recuperada.
     * @return A entidade correspondente ao identificador especificado, ou null se não for encontrada.
     */
    @Override
    public Carro findById(Long id) {
        try {
            Carro carro = cachedCarro.findById(id);
            if (carro == null) {
                carro = RobRepository.super.findById(id);
                cachedCarro.save(carro);
            }
            return carro;
        } catch (Exception e) {
            throw new RuntimeException("Nao foi possivel encontrar o carro com o id " + id, e);
        }

    }

    /**
     * Salva uma nova entidade no banco de dados.
     *
     * @param carro A entidade a ser salva no banco de dados.
     */
    @Override
    public Long save(Carro carro) {
        Long id = RobRepository.super.save(carro);
        Carro carroSalvo = RobRepository.super.findById(id);
        cachedCarro.save(carroSalvo);
        return id;
    }

    /**
     * Atualiza uma entidade existente no banco de dados.
     *
     * @param carro A entidade a ser atualizada no banco de dados.
     */
    @Override
    public void update(Carro carro) {
        RobRepository.super.update(carro);
        cachedCarro.update(carro);
    }

    /**
     * Exclui uma entidade do banco de dados com base no seu identificador único.
     *
     * @param id O identificador único da entidade a ser excluída do banco de dados.
     */
    @Override
    public void delete(Long id) {
        RobRepository.super.delete(id);
        cachedCarro.delete(id);
    }

    @Override
    public JdbcClient getConnection() {
        return jdbcClient;
    }
}
