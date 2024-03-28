
package com.imrob.locadoraveiculos.gui.model;

import com.imrob.locadoraveiculos.DTO.ClienteDTO;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelCliente extends AbstractTableModel {
    private List<ClienteDTO> clientes;
    String[] colunas = ClienteDTO.getColunas();

    public TableModelCliente(List<ClienteDTO> clientes) {
        this.clientes = clientes;
    }
    
    @Override
    public int getRowCount() {
        return clientes.size();
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
            case 0 -> clientes.get(rowIndex).getId();
            case 1 -> clientes.get(rowIndex).getNome();
            case 2 -> clientes.get(rowIndex).getRg();
            case 3 -> clientes.get(rowIndex).getCpf();
            case 4 -> clientes.get(rowIndex).getCnh();
            case 5 -> clientes.get(rowIndex).getDataVencimentoCNH();
            case 6 -> clientes.get(rowIndex).getEmail();
            case 7 -> clientes.get(rowIndex).getEndereco().getRua();
            case 8 -> clientes.get(rowIndex).getEndereco().getNumero();
            case 9 -> clientes.get(rowIndex).getEndereco().getBairro();
            case 10 -> clientes.get(rowIndex).getEndereco().getCidade();
            case 11 -> clientes.get(rowIndex).getEndereco().getEstado();
            case 12 -> clientes.get(rowIndex).getEndereco().getCep();
            default -> clientes.get(rowIndex).getTelefone();
        };
    }
    
}
