package com.imrob.locadoraveiculos.gui.model;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Um modelo de tabela genérico para mapear entidades para uma tabela Swing.
 *
 * Obs: Os metodos gettters da entidade devem sequir a ordem das colunas da tabela.
 *
 * @param <ENTITY> o tipo da entidade a ser mapeada
 */
public class MappedTableModel<ENTITY> extends AbstractTableModel {
    private List<ENTITY> lista;
    private String[] columnNames;
    private List<String> metodos;

    /**
     * Constrói um modelo de tabela mapeado com as entidades fornecidas.
     * As colunas da tabela serão nomeadas de acordo com os nomes dos atributos da entidade.
     *
     * @param entities a lista de entidades a serem mapeadas
     */
    public MappedTableModel(List<ENTITY> entities){
        lista = entities;
        columnNames = getColumnNames();
        metodos = new ArrayList<>();
        setMetodos();
    }

    /**
     * Constrói um modelo de tabela mapeado com as entidades fornecidas e os nomes das colunas especificados.
     *
     * @param entities a lista de entidades a serem mapeadas
     * @param columnNames os nomes das colunas da tabela
     */
    public MappedTableModel(List<ENTITY> entities, String[] columnNames){
        lista = entities;
        this.columnNames = columnNames;
        metodos = new ArrayList<>();
        setMetodos();
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
            Method method = lista.get(rowIndex).getClass().getMethod(metodos.get(columnIndex));
            return method.invoke(lista.get(rowIndex));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Define os nomes dos metodos da entidade.
     */
    private void setMetodos(){
        Method[] arrayMethod = lista.get(0).getClass().getDeclaredMethods();

        for (Method m : arrayMethod){
            String nomeMetodo = m.getName();
            if (nomeMetodo.startsWith("get")){
                metodos.add(m.getName());
            }
        }
    }

    /**
     * Define os nomes das colunas da tabela.
     *
     * @param columnNames os nomes das colunas da tabela
     */
    public void setColumnNames(String[] columnNames){
        this.columnNames = columnNames;
    }
}
