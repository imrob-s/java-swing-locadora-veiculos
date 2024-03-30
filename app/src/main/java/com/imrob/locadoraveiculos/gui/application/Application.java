package com.imrob.locadoraveiculos.gui.application;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.imrob.locadoraveiculos.DTO.CarroDTO;
import com.imrob.locadoraveiculos.DTO.FabricanteDTO;
import com.imrob.locadoraveiculos.DTO.ModeloDTO;
import com.imrob.locadoraveiculos.gui.components.MainForm;
import com.imrob.locadoraveiculos.services.CarroService;
import com.imrob.locadoraveiculos.services.FabricanteService;
import com.imrob.locadoraveiculos.services.ModeloService;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    public static java.util.List<ModeloDTO> listaModelo;
    public static java.util.List<FabricanteDTO> listaFabricante;
    public static java.util.List<CarroDTO> listaCarro;
    
    private MainForm mainForm = new MainForm();
    
    public Application() {
        init();
        carregarDados();
    }
    
    public static void carregarDados() {
        ModeloService modeloService = new ModeloService();
        FabricanteService fabricanteService = new FabricanteService();
        CarroService carroService = new CarroService();
        listaModelo = modeloService.findAll();
        listaFabricante = fabricanteService.findAll();
        listaCarro = carroService.findAll();      
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getRootPane().putClientProperty(FlatClientProperties.FULL_WINDOW_CONTENT, true);
        setSize(new Dimension(1366, 768));
        setLocationRelativeTo(null);
        getContentPane().add(mainForm);
    }

    public static void main(String[] args) {
        FlatRobotoFont.install();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        EventQueue.invokeLater(() -> new Application().setVisible(true));
    }
}
