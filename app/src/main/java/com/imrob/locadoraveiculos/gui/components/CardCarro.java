package com.imrob.locadoraveiculos.gui.components;

import com.imrob.locadoraveiculos.DTO.CarroDTO;
import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import raven.swing.AvatarIcon;

public class CardCarro extends javax.swing.JPanel {
    
    public CardCarro() {
        initComponents();
        setOpaque(false);
    }
    
    public CardCarro(CarroDTO carro) {
        initComponents();
        setOpaque(false);
        setData(carro);
    }
    
    public void setData(CarroDTO carro) {
        lblModelo.setText(carro.getModelo());
        lblFabricante.setText(carro.getFabricante());
        txtAno.setText(String.valueOf(carro.getAno()));
        txtCor.setText(carro.getCor());
        txtPlaca.setText(carro.getPlaca());
        if (carro.getDisponivel()){
            txtDisponivel.setOpaque(true);
            txtDisponivel.setBackground(Color.GREEN);
            txtDisponivel.setForeground(Color.BLACK);
            txtDisponivel.setText("Disponível");
        } else {
            txtDisponivel.setOpaque(true);
            txtDisponivel.setBackground(Color.RED);
            txtDisponivel.setForeground(Color.WHITE);
            txtDisponivel.setText("Indisponível");
        }
        
        String imagePath = "/imgs/carro/" + carro.getModeloId() + ".png";
        URL imageURL = getClass().getResource(imagePath);
        if (imageURL != null) {
            lblImg.setIcon(new AvatarIcon(imageURL, 180, 100, 10));
        } else {
            lblImg.setIcon(new AvatarIcon(getClass().getResource("/imgs/img_carrodefault.png"), 180, 100, 10));
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImg = new javax.swing.JLabel();
        lblFabricante = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        lblCor = new javax.swing.JLabel();
        txtAno = new javax.swing.JLabel();
        txtCor = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JLabel();
        txtDisponivel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(200, 250));
        setMinimumSize(new java.awt.Dimension(200, 250));

        lblFabricante.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblFabricante.setForeground(new java.awt.Color(255, 255, 255));
        lblFabricante.setText("Fabricante");

        lblModelo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblModelo.setForeground(new java.awt.Color(255, 255, 255));
        lblModelo.setText("Modelo");

        lblPlaca.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblPlaca.setForeground(new java.awt.Color(204, 204, 204));
        lblPlaca.setText("Placa");

        lblAno.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblAno.setForeground(new java.awt.Color(204, 204, 204));
        lblAno.setText("Ano");

        lblCor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblCor.setForeground(new java.awt.Color(204, 204, 204));
        lblCor.setText("Cor");

        txtAno.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtAno.setForeground(new java.awt.Color(255, 255, 255));
        txtAno.setText("2023");

        txtCor.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtCor.setForeground(new java.awt.Color(255, 255, 255));
        txtCor.setText("Branco");

        txtPlaca.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtPlaca.setForeground(new java.awt.Color(255, 255, 255));
        txtPlaca.setText("ABC1234");

        txtDisponivel.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtDisponivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDisponivel.setText("Indisponivel");
        txtDisponivel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txtDisponivel.setPreferredSize(new java.awt.Dimension(85, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(lblFabricante))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPlaca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPlaca))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblCor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblAno, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAno, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCor, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(lblFabricante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblFabricante;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel txtAno;
    private javax.swing.JLabel txtCor;
    private javax.swing.JLabel txtDisponivel;
    private javax.swing.JLabel txtPlaca;
    // End of variables declaration//GEN-END:variables


}
