/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.imrob.locadoraveiculos;
import com.imrob.locadoraveiculos.services.FabricanteService;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.gui.TelaPrincipal;
import com.imrob.locadoraveiculos.repositories.FabricanteRepository;
import javax.swing.UIManager;

public class App {

    public static void main(String[] args) {
        setLookAndFeel();

        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);

    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatArcOrangeIJTheme());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
    }
}
