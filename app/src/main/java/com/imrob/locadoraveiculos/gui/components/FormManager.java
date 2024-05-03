package com.imrob.locadoraveiculos.gui.components;

import java.awt.*;
import javax.swing.*;

public class FormManager {

    private static FormManager instance;
    private JDesktopPane desktopPane;

    public static FormManager getInstance() {
        if (instance == null) {
            instance = new FormManager();
        }
        return instance;
    }

    private FormManager() {

    }

    public void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    public void showForm(String title, Component component) {
        JInternalFrame frame = new JInternalFrame(title, true, true, true, true);
        frame.setSize(component.getPreferredSize());
        frame.add(component);
        frame.setVisible(true);
        desktopPane.add(frame, 0);
    }
    
    public void showForm(String title, Component component, Boolean resizable) {
    JInternalFrame frame = new JInternalFrame(title, resizable, true, true, true);
    frame.setSize(component.getPreferredSize());
    frame.add(component);
    frame.setVisible(true);
    desktopPane.add(frame, 0);
    }
}
