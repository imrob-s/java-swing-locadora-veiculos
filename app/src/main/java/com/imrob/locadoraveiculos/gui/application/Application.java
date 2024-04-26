package com.imrob.locadoraveiculos.gui.application;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.imrob.locadoraveiculos.gui.components.MainForm;
import java.awt.*;
import javax.swing.*;

public class Application extends JFrame {
    
    private MainForm mainForm = new MainForm();
    
    public Application() {
        init();
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
