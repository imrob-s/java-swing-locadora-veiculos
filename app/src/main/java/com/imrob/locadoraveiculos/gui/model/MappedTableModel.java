package com.imrob.locadoraveiculos.gui.model;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MappedTableModel<ENTITY> extends AbstractTableModel {
    private List<ENTITY> lista;
    private String[] columnNames;
    private List<String> metodos;

    public MappedTableModel(List<ENTITY> entities){
        lista = entities;
        columnNames = getColumnNames();
        metodos = new ArrayList<>();
        setMetodos();
    }
    
    public MappedTableModel(List<ENTITY> entities, String[] columnNames){
        lista = entities;
        this.columnNames = columnNames;
        metodos = new ArrayList<>();
        setMetodos();
    }

    public String[] getColumnNames() {
        Field[] campos = lista.get(0).getClass().getDeclaredFields();
        String[] colunas = new String[campos.length];

        for (int i = 0; i < campos.length; i++) {
            colunas[i] = campos[i].getName();
        }
        return colunas;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

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
    
    private void setMetodos(){
        Method[] arrayMethod = lista.get(0).getClass().getDeclaredMethods();

        for (Method m : arrayMethod){
            String nomeMetodo = m.getName();
            if (nomeMetodo.startsWith("get")){
                metodos.add(m.getName());
            }
        }
    }
    
    public void setColumnNames(String[] columnNames){
        this.columnNames = columnNames;
    }
}
