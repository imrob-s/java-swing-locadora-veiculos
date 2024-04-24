package com.imrob.locadoraveiculos.gui.model;

import java.awt.Component;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

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
    private JTable table;

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
    
    public MappedTableModel(List<ENTITY> entities, JTable table) {
        lista = entities;
        columnNames = getColumnNames();
        metodos = setMetodos();
        this.table = table;
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
    
    /**
     * Exclui uma ou várias colunas da tabela.
     *
     * @param columnsToExclude a lista de colunas a serem excluídas
     */
    public void excludeColumns(String[] columnsToExclude) {
        List<String> newColumnNamesList = new ArrayList<>(Arrays.asList(columnNames));
        List<Method> newMethodsList = new ArrayList<>(Arrays.asList(metodos));

        for (String column : columnsToExclude) {
            int columnIndex = newColumnNamesList.indexOf(column);
            if (columnIndex != -1) {
                newColumnNamesList.remove(column);
                newMethodsList.remove(columnIndex);
            }
        }

        columnNames = newColumnNamesList.toArray(new String[0]);
        metodos = newMethodsList.toArray(new Method[0]);
    }
    
    public void setTable(JTable table) {
        this.table = table;
    }

    public void setPreferredColumnWidths() {
        if (table == null) {
            System.err.println("Você deve definir uma instância de JTable antes de chamar setPreferredColumnWidths.");
            return;
        }

        TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < getColumnCount(); column++) {
            int maxWidth = 0;
            for (int row = 0; row < getRowCount(); row++) {
                Object value = getValueAt(row, column);
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component comp = cellRenderer.getTableCellRendererComponent(table, value, false, false, row, column);
                maxWidth = Math.max(comp.getPreferredSize().width, maxWidth);
            }
            TableColumn tableColumn = columnModel.getColumn(column);
            tableColumn.setPreferredWidth(maxWidth + 20);
        }
    }
    

    /*
     * Coloca a primeira letra da string em maiusculo.
     */
    private static String capitalize(String palavra) {
        return Character.toUpperCase(palavra.charAt(0)) + palavra.substring(1);
    }
}
