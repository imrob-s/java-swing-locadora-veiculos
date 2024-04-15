package com.imrob.locadoraveiculos.repositories;

import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.entities.Locacao;
import com.imrob.locadoraveiculos.repositories.cache.CachedRepository;
import com.imrob.locadoraveiculos.repositories.impl.RobRepository;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

public class LocacaoRepository implements RobRepository<Locacao, Long> {
    private final JdbcClient jdbcClient;
    private final CachedRepository<Locacao, Long> cachedLocacao;

    public LocacaoRepository() {
        this.jdbcClient = DatabaseConfig.getConnection();
        this.cachedLocacao = new CachedRepository<>(Locacao.class, Long.class);
    }

    /**
     * Recupera todas as entidades armazenadas no banco de dados.
     *
     * @return Uma lista contendo todas as entidades encontradas.
     */
    @Override
    public List<Locacao> findAll() {
        List<Locacao> locacoes = cachedLocacao.findAll();
        if (locacoes == null) {
            locacoes = RobRepository.super.findAll();
            cachedLocacao.saveAll(locacoes);
        }
        return locacoes;
    }

    /**
     * Recupera uma entidade do banco de dados pelo seu identificador único.
     *
     * @param id O identificador único da entidade a ser recuperada.
     * @return A entidade correspondente ao identificador especificado, ou null se não for encontrada.
     */
    @Override
    public Locacao findById(Long id) {
        try {
            Locacao locacao = cachedLocacao.findById(id);
            if (locacao == null) {
                locacao = RobRepository.super.findById(id);
                cachedLocacao.save(locacao);
            }
            return locacao;
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel encontrar a locacao com id " + id, e);
        }
    }

    /**
     * Salva uma nova entidade no banco de dados.
     *
     * @param locacao A entidade a ser salva no banco de dados.
     */
    @Override
    public Long save(Locacao locacao) {
        Long id = RobRepository.super.save(locacao);
        Locacao locacaoSalva = RobRepository.super.findById(id);
        cachedLocacao.save(locacaoSalva);
        return id;
    }

    /**
     * Atualiza uma entidade existente no banco de dados.
     *
     * @param locacao A entidade a ser atualizada no banco de dados.
     */
    @Override
    public void update(Locacao locacao) {
        RobRepository.super.update(locacao);
        cachedLocacao.update(locacao);
    }

    /**
     * Exclui uma entidade do banco de dados com base no seu identificador único.
     *
     * @param id O identificador único da entidade a ser excluída do banco de dados.
     */
    @Override
    public void delete(Long id) {
        RobRepository.super.delete(id);
        cachedLocacao.delete(id);
    }

    @Override
    public JdbcClient getConnection() {
        return jdbcClient;
    }
}
