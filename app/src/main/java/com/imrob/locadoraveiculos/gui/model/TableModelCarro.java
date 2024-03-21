
package com.imrob.locadoraveiculos.gui.model;

import com.imrob.locadoraveiculos.DTO.CarroDTO;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelCarro extends AbstractTableModel{
    private List<CarroDTO> lista;
    String[] colunas = CarroDTO.getColunas();
    
    public TableModelCarro(List<CarroDTO> carros){
        lista = carros;
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
        return switch (columnIndex) {
            case 0 -> lista.get(rowIndex).getId();
            case 1 -> lista.get(rowIndex).getNome();
            case 2 -> lista.get(rowIndex).getFabricante();
            case 3 -> lista.get(rowIndex).getCor();
            case 4 -> lista.get(rowIndex).getPlaca();
            case 5 -> lista.get(rowIndex).getValorLocacao();
            default -> lista.get(rowIndex).getDisponivel();
        };
    } 
}
