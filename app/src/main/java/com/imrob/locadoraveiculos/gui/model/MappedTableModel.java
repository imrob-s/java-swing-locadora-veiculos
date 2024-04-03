package com.imrob.locadoraveiculos.gui.model;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Um modelo de tabela genérico para mapear entidades para uma tabela Swing.
 *
 * Obs: Os metodos gettters da entidade devem sequir a ordem das colunas da tabela.
 *
 * @param <ENTITY> o tipo da entidade a ser mapeada
 * @author Rob Silva
 */
public class MappedTableModel<ENTITY> extends AbstractTableModel {
    private List<ENTITY> lista;
    private String[] columnNames;
    private Method[] metodos;

    /**
     * Constrói um modelo de tabela mapeado com as entidades fornecidas.
     * As colunas da tabela serão nomeadas de acordo com os nomes dos atributos da entidade.
     *
     * @param entities a lista de entidades a serem mapeadas
     */
    public MappedTableModel(List<ENTITY> entities) {
        lista = entities;
        columnNames = getColumnNames();
        metodos = setMetodos();
    }

    /**
     * Constrói um modelo de tabela mapeado com a lista de entidades fornecida e os nomes das colunas especificados.
     *
     * @param entities a lista de entidades a serem mapeadas
     * @param columnNames os nomes das colunas da tabela
     */
    public MappedTableModel(List<ENTITY> entities, String[] columnNames){
        lista = entities;
        this.columnNames = getColumnNames();
        metodos = setMetodos();
        this.columnNames = columnNames;
    }

    /**
     * Obtém os nomes das colunas da tabela com base nos atributos da entidade.
     *
     * @return um array de strings contendo os nomes das colunas da tabela
     */
    public String[] getColumnNames() {

        Field[] campos = lista.get(0).getClass().getDeclaredFields();
        String[] colunas = new String[campos.length];

        for (int i = 0; i < campos.length; i++) {
            colunas[i] = campos[i].getName();
        }
        return colunas;
    }

    /*
     * Obtém o número de linhas da tabela.
     */
    @Override
    public int getRowCount() {
        return lista.size();
    }

    /*
     * Obtém o número de colunas da tabela.
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    /**
     * Obtém o valor contido em uma determinada posição da tabela.
     *
     * @param rowIndex a linha da tabela
     * @param columnIndex a coluna da tabela
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Method method = metodos[columnIndex];
            return method.invoke(lista.get(rowIndex));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Define os nomes dos metodos da entidade.
     */
    private Method[] setMetodos() {
        Method[] metodosOrdenados = new Method[columnNames.length];

        for (int i = 0; i < metodosOrdenados.length; i++) {
            String nomeMetodo = "get" + capitalize(columnNames[i]);
            try {
                metodosOrdenados[i] = lista.get(0).getClass().getDeclaredMethod(nomeMetodo);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return metodosOrdenados;
    }

    /**
     * Define os nomes das colunas da tabela.
     *
     * @param columnNames os nomes das colunas da tabela
     */
    public void setColumnNames(String[] columnNames){
        this.columnNames = columnNames;
    }

    /*
     * Coloca a primeira letra da string em maiusculo.
     */
    private static String capitalize(String palavra) {
        return Character.toUpperCase(palavra.charAt(0)) + palavra.substring(1);
    }
}
