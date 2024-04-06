package com.imrob.locadoraveiculos;

import ch.qos.logback.core.net.server.Client;
import com.imrob.locadoraveiculos.DTO.CarroDTO;
import com.imrob.locadoraveiculos.entities.Carro;
import com.imrob.locadoraveiculos.entities.Cliente;
import com.imrob.locadoraveiculos.entities.Fabricante;
import com.imrob.locadoraveiculos.entities.Modelo;
import com.imrob.locadoraveiculos.gui.model.MappedTableModel;
import com.imrob.locadoraveiculos.repositories.CarroRepository;
import com.imrob.locadoraveiculos.repositories.ModeloRepository;
import com.imrob.locadoraveiculos.repositories.TesteRepository;
import com.imrob.locadoraveiculos.services.CarroService;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static java.util.stream.Collectors.counting;

public class Teste extends JFrame {
    private JTable tabela;

    public Teste() {
//        // CarroRepository repository = new CarroRepository();
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

        TesteRepository repository = new TesteRepository();
        Fabricante fabricante = new Fabricante(20L, "Outro Texto de Teste");
        repository.delete(19L);



        SwingUtilities.invokeLater(() -> {
            // new Teste();
        });
    }
}
