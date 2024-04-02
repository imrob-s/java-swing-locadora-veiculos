package com.imrob.locadoraveiculos;

import com.imrob.locadoraveiculos.DTO.CarroDTO;
import com.imrob.locadoraveiculos.entities.Carro;
import com.imrob.locadoraveiculos.gui.model.MappedTableModel;
import com.imrob.locadoraveiculos.repositories.CarroRepository;
import com.imrob.locadoraveiculos.services.CarroService;

import javax.swing.*;
import java.util.List;

public class Teste extends JFrame {
    private JTable tabela;

    public Teste() {
        CarroRepository repository = new CarroRepository();
        List<Carro> carros = repository.findAll();

        setTitle("Exemplo de JFrame com JTable");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        MappedTableModel<Carro> model = new MappedTableModel<>(carros);
        tabela = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabela);

        getContentPane().add(scrollPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Teste();
        });
    }
}
