package com.imrob.locadoraveiculos.gui.components;

import com.imrob.locadoraveiculos.DTO.CarroDTO;
import java.awt.Color;
import java.net.URL;
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
            lblImg.setIcon(new AvatarIcon(imageURL, 150, 84, 10));
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
        setMaximumSize(new java.awt.Dimension(180, 248));
        setMinimumSize(new java.awt.Dimension(180, 248));
        setPreferredSize(new java.awt.Dimension(180, 248));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lblFabricante.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        lblFabricante.setText("Fabricante");

        lblModelo.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        lblModelo.setText("Modelo");

        lblPlaca.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        lblPlaca.setForeground(new java.awt.Color(204, 204, 204));
        lblPlaca.setText("Placa");

        lblAno.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        lblAno.setForeground(new java.awt.Color(204, 204, 204));
        lblAno.setText("Ano");

        lblCor.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        lblCor.setForeground(new java.awt.Color(204, 204, 204));
        lblCor.setText("Cor");

        txtAno.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtAno.setForeground(new java.awt.Color(204, 204, 204));
        txtAno.setText("2023");

        txtCor.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtCor.setForeground(new java.awt.Color(204, 204, 204));
        txtCor.setText("Branco");

        txtPlaca.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtPlaca.setForeground(new java.awt.Color(204, 204, 204));
        txtPlaca.setText("ABC1234");

        txtDisponivel.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtDisponivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDisponivel.setText("Indisponivel");
        txtDisponivel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txtDisponivel.setPreferredSize(new java.awt.Dimension(85, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAno)
                            .addComponent(lblCor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPlaca)
                            .addComponent(lblModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAno, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFabricante, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(txtDisponivel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(lblFabricante))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAno)
                    .addComponent(txtAno))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCor)
                    .addComponent(txtCor))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(txtPlaca))
                .addGap(12, 12, 12)
                .addComponent(txtDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked


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
