package com.imrob.locadoraveiculos.gui.model;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class MagicTableModel<ENTITY> extends AbstractTableModel {
    private List<ENTITY> lista;
    String[] colunas = getColunas();

    public MagicTableModel(List<ENTITY> entities){
        lista = entities;
        colunas = getColunas();
    }

    public String[] getColunas() {
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
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Method method = lista.get(rowIndex).getClass().getMethod("get" + capitalize(colunas[columnIndex]));
            return method.invoke(lista.get(rowIndex));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
