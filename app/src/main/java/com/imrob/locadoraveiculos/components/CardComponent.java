package com.imrob.locadoraveiculos.components;

import com.imrob.locadoraveiculos.entities.CardCarro;
import com.imrob.locadoraveiculos.entities.Carro;

/**
 *
 * @author Rob
 */
public class CardComponent extends javax.swing.JPanel {

    private boolean selected;
    
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }
    
    public CardComponent() {
        initComponents();
        setOpaque(false);
    }
    
    public CardComponent(Carro carro) {
        initComponents();
        setOpaque(false);
        setData(carro);
    }
    
    public void setData(Carro carro) {
        txtModelo.setText(String.valueOf(carro.getIdModelo()));
        txtAno.setText(String.valueOf(carro.getAno()));
        txtCor.setText(carro.getCor());
        txtPlaca.setText(carro.getPlaca());
        // lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/carro/" + carro.getIdModelo() +".png")));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImg = new javax.swing.JLabel();
        txtModelo = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        lblCor = new javax.swing.JLabel();
        txtAno = new javax.swing.JLabel();
        txtCor = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(200, 250));
        setMinimumSize(new java.awt.Dimension(200, 250));

        lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/carro/img_carro.png"))); // NOI18N

        txtModelo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(51, 51, 51));
        txtModelo.setText("Modelo");

        lblPlaca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPlaca.setForeground(new java.awt.Color(102, 102, 102));
        lblPlaca.setText("Placa");

        lblAno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAno.setForeground(new java.awt.Color(102, 102, 102));
        lblAno.setText("Ano");

        lblCor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCor.setForeground(new java.awt.Color(102, 102, 102));
        lblCor.setText("Cor");

        txtAno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAno.setText("2023");

        txtCor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCor.setText("Branco");

        txtPlaca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPlaca.setText("ABC1234");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblPlaca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPlaca))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblCor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAno, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCor, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtModelo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAno)
                    .addComponent(txtAno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCor)
                    .addComponent(txtCor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(txtPlaca))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel txtAno;
    private javax.swing.JLabel txtCor;
    private javax.swing.JLabel txtModelo;
    private javax.swing.JLabel txtPlaca;
    // End of variables declaration//GEN-END:variables


}
