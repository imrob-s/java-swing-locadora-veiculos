
package com.imrob.locadoraveiculos.gui.forms;

import com.imrob.locadoraveiculos.DTO.CarroDTO;
import com.imrob.locadoraveiculos.DTO.ClienteDTO;
import com.imrob.locadoraveiculos.DTO.LocacaoDTO;
import com.imrob.locadoraveiculos.DTO.SeguradoraDTO;
import com.imrob.locadoraveiculos.gui.forms.locacao.LocacaoCarro;
import com.imrob.locadoraveiculos.gui.forms.locacao.LocacaoCliente;
import com.imrob.locadoraveiculos.gui.forms.locacao.LocacaoDetalhes;
import com.imrob.locadoraveiculos.gui.forms.locacao.LocacaoFinalizacao;
import java.awt.Color;
import java.awt.Component;

public class LocacaoForm extends javax.swing.JPanel {
    private static LocacaoForm instance;
    private static ClienteDTO cliente;
    private static CarroDTO carro;
    private static SeguradoraDTO seguradora;
    private static LocacaoDTO locacao = new LocacaoDTO();

    private LocacaoForm() {
        initComponents();
        setBackground(Color.white);
        Component[] components = new Component[]{new LocacaoCliente(btnProximo), new LocacaoCarro(btnProximo), new LocacaoDetalhes(), new LocacaoFinalizacao()};
        panelSlider.setSliderComponent(components);
        progressIndicator.initSlider(panelSlider);
        btnProximo.setEnabled(false);
    }
    
    public static LocacaoForm getInstance() {
        if (instance == null) {
            synchronized (LocacaoForm.class) {
                if (instance == null) {
                    instance = new LocacaoForm();
                }
            }
        }
        return instance;
    }
    
    public static void closeInstance() {
        instance = null;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public CarroDTO getCarro() {
        return carro;
    }

    public static void setCarro(CarroDTO carro) {
        LocacaoForm.carro = carro;
    }

    public SeguradoraDTO getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(SeguradoraDTO seguradora) {
        this.seguradora = seguradora;
    }

    public LocacaoDTO getLocacao() {
        return locacao;
    }

    public void setLocacao(LocacaoDTO locacao) {
        this.locacao = locacao;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressIndicator = new com.imrob.locadoraveiculos.gui.components.ProgressIndicator();
        panelSlider = new com.imrob.locadoraveiculos.gui.components.PanelSlider();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setOpaque(false);

        progressIndicator.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 80, 5, 80));
        progressIndicator.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Cliente", "Carro", "Detalhes", "Finalização" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        progressIndicator.setOpaque(false);
        progressIndicator.setProgress(0.0F);
        progressIndicator.setProgressColorGradient(new java.awt.Color(0, 153, 0));

        panelSlider.setOpaque(false);

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnProximo.setText("Próximo");
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProximo)
                .addContainerGap())
            .addComponent(progressIndicator, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(progressIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProximo))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        progressIndicator.previous();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        progressIndicator.next();
    }//GEN-LAST:event_btnProximoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnProximo;
    private com.imrob.locadoraveiculos.gui.components.PanelSlider panelSlider;
    private com.imrob.locadoraveiculos.gui.components.ProgressIndicator progressIndicator;
    // End of variables declaration//GEN-END:variables
}
