
package com.imrob.locadoraveiculos.Utils;

import java.awt.Component;
import javax.swing.JInternalFrame;

public class Utils {

    public Utils() {
        throw new IllegalStateException("Classe Utilitaria");
    }
    
    public static void sair(Component component){
        while (!(component instanceof JInternalFrame) && component != null) {
        component = component.getParent();
        }
        
        if (component instanceof JInternalFrame) {
        JInternalFrame internalFrame = (JInternalFrame) component;
        internalFrame.dispose();
        }
    }
}
