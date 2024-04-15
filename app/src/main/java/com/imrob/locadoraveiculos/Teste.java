package com.imrob.locadoraveiculos;

import com.imrob.locadoraveiculos.entities.Fabricante;
import com.imrob.locadoraveiculos.repositories.deprecated.FabricanteRepository;

import javax.swing.*;

public class Teste extends JFrame {
    private JTable tabela;

    public Teste() {
          // FabricanteRepository repository = new FabricanteRepository();
//        ModeloRepository repository = new ModeloRepository();
//        // List<Modelo> modelos = repository.findAll();
//        List<Carro> carros = new TesteRepository().findAll();
//
//        setTitle("Exemplo de JFrame com JTable");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(400, 300);
//        setLocationRelativeTo(null);
//
//        MappedTableModel<Carro> model = new MappedTableModel<>(carros);
//        // model.setColumnNames(new String[]{"Identificação", "Modelo", "Id do Fabricante"});
//        tabela = new JTable(model);
//        JScrollPane scrollPane = new JScrollPane(tabela);
//
//        getContentPane().add(scrollPane);
//        setVisible(true);
    }

    public static void main(String[] args) {
        FabricanteRepository repository = new FabricanteRepository();
        Fabricante fabricante = new Fabricante(20L, "Outro Texto de Teste");
        repository.delete(19L);



        SwingUtilities.invokeLater(() -> {
            // new Teste();
        });
    }
}
