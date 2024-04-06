package com.imrob.locadoraveiculos.repositories.impl;

import org.springframework.jdbc.core.simple.JdbcClient;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta interface representa um repositório genérico para realizar operações CRUD em entidades em um banco de dados.
 * @param <ENTITY> O tipo de entidade gerenciada por este repositório.
 * @param <ID_TYPE> O tipo do identificador da entidade.
 */
public interface RobRepository<ENTITY, ID_TYPE> {
    /**
     * Recupera todas as entidades armazenadas no banco de dados.
     *
     * @return Uma lista contendo todas as entidades encontradas.
     */
    default List<ENTITY> findAll(){
        JdbcClient jdbcClient = getConnection();
        Class<ENTITY> entityClass = getEntityClass();
        String tableName = entityClass.getSimpleName().toLowerCase();
        String sql = "SELECT * FROM " + tableName;

        return jdbcClient
                .sql(sql)
                .query(entityClass)
                .list();
    }

    /**
     * Recupera uma entidade do banco de dados pelo seu identificador único.
     *
     * @param id O identificador único da entidade a ser recuperada.
     * @return A entidade correspondente ao identificador especificado, ou null se não for encontrada.
     */
    default ENTITY findById(ID_TYPE id) {
        JdbcClient jdbcClient = getConnection();
        Class<ENTITY> entityClass = getEntityClass();
        String tableName = entityClass.getSimpleName().toLowerCase();
        String sql = "SELECT * FROM " + tableName + " WHERE id = :id";

        return jdbcClient
                .sql(sql)
                .param("id", id)
                .query(entityClass)
                .single();
    }

    /**
     * Salva uma nova entidade no banco de dados.
     *
     * @param entity A entidade a ser salva no banco de dados.
     */
    default void save(ENTITY entity) {
        JdbcClient jdbcClient = getConnection();
        Class<ENTITY> entityClass = getEntityClass();
        String tableName = entityClass.getSimpleName().toLowerCase();
        List<Object> values = getSaveValues(entity);

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("INSERT INTO ")
                .append(tableName)
                .append(" (");

        Field[] fields = entityClass.getDeclaredFields();
        for (int i = 0; i <= values.size(); i++) {
            if (!fields[i].getName().equals("id")) {
                String fieldName = fields[i].getName();
                sqlBuilder.append(fieldName)
                        .append(", ");
            }
        }

        sqlBuilder.setLength(sqlBuilder.length() - 2);
        sqlBuilder.append(") VALUES (");

        for (int i = 0; i <= values.size(); i++) {
            if (!fields[i].getName().equals("id")) {
                sqlBuilder.append("?, ");
            }
        }

        sqlBuilder.setLength(sqlBuilder.length() - 2);
        sqlBuilder.append(")");
        String sql = sqlBuilder.toString();

        jdbcClient.sql(sql)
                .params(values)
                .update();
    }

    /**
     * Atualiza uma entidade existente no banco de dados.
     *
     * @param entity A entidade a ser atualizada no banco de dados.
     */
    default void update(ENTITY entity) {
        JdbcClient jdbcClient = getConnection();
        Class<ENTITY> entityClass = getEntityClass();
        String tableName = entityClass.getSimpleName().toLowerCase();
        List<Object> values = getUpdateValues(entity);

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("UPDATE ")
                .append(tableName)
                .append(" SET ");

        Field[] fields = entityClass.getDeclaredFields();
        for (int i = 0; i < values.size(); i++) {
            if (!fields[i].getName().equals("id")) {
                String fieldName = fields[i].getName();
                sqlBuilder.append(fieldName)
                        .append(" = ?, ");
            }
        }

        sqlBuilder.setLength(sqlBuilder.length() - 2);
        sqlBuilder.append(" WHERE id = ?");
        String sql = sqlBuilder.toString();

        jdbcClient.sql(sql)
                .params(values)
                .update();
    }

    /**
     * Exclui uma entidade do banco de dados com base no seu identificador único.
     *
     * @param id O identificador único da entidade a ser excluída do banco de dados.
     */
    default void delete(ID_TYPE id){
        JdbcClient jdbcClient = getConnection();
        Class<ENTITY> entityClass = getEntityClass();
        String tableName = entityClass.getSimpleName().toLowerCase();
        String sql = "DELETE FROM " + tableName + " WHERE id = :id";

        jdbcClient.sql(sql)
                .param("id", id)
                .update();
    }

    /**
     * Obtém o cliente JDBC usado para executar operações no banco de dados.
     *
     * @return A conexão com o banco de dados usada pelo jdbcClient.
     */
    JdbcClient getConnection();

    /**
     * Obtém a classe da entidade.
     *
     * @return A classe da entidade.
     */
    @SuppressWarnings("unchecked")
    private Class<ENTITY> getEntityClass() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericInterfaces()[0];
        return (Class<ENTITY>) type.getActualTypeArguments()[0];
    }

    /**
     * Obtém os valores para inserção de uma entidade no banco de dados.
     *
     * @return Uma lista contendo os valores a serem inseridos.
     */
    private List<Object> getSaveValues(ENTITY entity) {
        List<Object> values = new ArrayList<>();
        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field field : fields) {
            String fieldName = field.getName();
            if (!fieldName.equals("id")) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(entity);
                    values.add(value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
        return values;
    }

    /**
     * Obtém os valores para atualização de uma entidade no banco de dados.
     *
     * @return Uma lista contendo os valores a serem atualizados.
     */
    private List<Object> getUpdateValues(ENTITY entity) {
        List<Object> values = getSaveValues(entity);
        try {
            Field idField = getEntityClass().getDeclaredField("id");
            idField.setAccessible(true);
            Object id = idField.get(entity);
            values.add(id);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
        return values;
    }
}

