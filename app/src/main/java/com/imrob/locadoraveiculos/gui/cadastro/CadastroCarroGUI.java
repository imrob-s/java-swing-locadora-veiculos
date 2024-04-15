
package com.imrob.locadoraveiculos.gui.cadastro;

import com.imrob.locadoraveiculos.DTO.CarroDTO;
import com.imrob.locadoraveiculos.DTO.FabricanteDTO;
import com.imrob.locadoraveiculos.DTO.ModeloDTO;
import com.imrob.locadoraveiculos.Utils.Utils;
import com.imrob.locadoraveiculos.gui.application.Application;
import com.imrob.locadoraveiculos.services.CarroService;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;

import com.imrob.locadoraveiculos.services.FabricanteService;
import com.imrob.locadoraveiculos.services.ModeloService;
import raven.swing.AvatarIcon;

public class CadastroCarroGUI extends javax.swing.JPanel {

    private final List<FabricanteDTO> listaFabricante = new FabricanteService().findAll();
    private final List<ModeloDTO> listaModelo = new ModeloService().findAll();
    private FabricanteDTO fabricanteSelecionado;
    private ModeloDTO modeloSelecionado;
    

    public CadastroCarroGUI() {
        initComponents();
        carregarCboFabricante();
    }
    
    public void carregarCboFabricante() { 
        cboFabricante.removeAllItems();
        
        for (FabricanteDTO f : listaFabricante) {
            cboFabricante.addItem(f.getNome());
        }
        
        if (!listaFabricante.isEmpty()) {
            carregarCboModelo(listaFabricante.get(0));
        }
    }
    
    public void carregarCboModelo(FabricanteDTO fabricante){
        cboModelo.removeAllItems();
        for (ModeloDTO modelo : listaModelo) {
            if (Objects.equals(modelo.getFabricanteId(), fabricante.getId())) {
                cboModelo.addItem(modelo.getNome());
            }
        }
    }
    
    public void carregarCboCor(){
        String[] listaCores = {
            "AMARELO", "AZUL", "BEGE", "BRANCA", "CINZA", "DOURADA",
            "GRENÁ", "LARANJA", "MARROM", "PRATA", "PRETA", "ROSA",
            "ROXA", "VERDE", "VERMELHA", "FANTASIA"
        };
        
    }
    
    private FabricanteDTO obterFabricanteSelecionado() {
       
        String nomeFabricanteSelecionado = cboFabricante.getSelectedItem().toString();
        for (FabricanteDTO fabricante : listaFabricante) {
            if (fabricante.getNome().equals(nomeFabricanteSelecionado)) {
                return fabricante;
            }
        
        }
        return null;
    }
    
    private ModeloDTO obterModeloSelecionado() {
    if(cboModelo.getSelectedItem() == null){
        return null;
    }
    
        String nomeModeloSelecionado = cboModelo.getSelectedItem().toString();
        for (ModeloDTO modelo : listaModelo) {
            if (modelo.getNome().equals(nomeModeloSelecionado)) {
                return modelo;
            }
        }
    
    return null;
    
    }
    
    
    private void salvar() {
        CarroService service = new CarroService();
        CarroDTO carro = new CarroDTO();
        
        if (camposPreenchidos()){
        try {
            carro.setFabricanteId(fabricanteSelecionado.getId());
            carro.setModeloId(obterModeloSelecionado().getId());
            carro.setAno(Integer.valueOf(txtAno.getText()));
            carro.setCor(cboCor.getSelectedItem().toString());
            carro.setPlaca(txtPlaca.getText());
            carro.setValorLocacao(Double.parseDouble(txtPreco.getText().replace(",", ".")));
            carro.setDisponivel(cbDisponivel.isSelected());
            
            service.save(carro);
            Application.listaCarro = service.findAll();
            JOptionPane.showMessageDialog(null, "Carro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
            
            } catch (Exception ex) {
                
                JOptionPane.showMessageDialog(null, "Erro ao salvar o carro no sistema: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            
            JOptionPane.showMessageDialog(null, "Obrigatório preencher todos os campos!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limparCampos(){
        txtAno.setText("");
        cboCor.setSelectedIndex(1);
        txtPlaca.setText("");
        txtPreco.setText("");
    }
    
    private Boolean camposPreenchidos() {
        if (txtAno.getText().isBlank() ||
            cboCor.getSelectedItem().toString().equals("SELECIONE") ||
            txtPlaca.getText().isBlank() ||
            txtPreco.getText().isBlank()) {
            return false;
        } else {
            return true;
        }
    }
    
    private void mostrarCarro(){
        if(modeloSelecionado == null){
            return;
        }
        String imagePath = "/imgs/carro/" + modeloSelecionado.getId() + ".png";
        URL imageURL = getClass().getResource(imagePath);
        if (imageURL != null) {
            lblImg.setIcon(new AvatarIcon(imageURL, 255, 141, 10));
        } else {
            lblImg.setIcon(new AvatarIcon(getClass().getResource("/imgs/img_carrodefault.png"), 255, 141, 10));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCenter = new javax.swing.JPanel();
        lblAno = new javax.swing.JLabel();
        lblFabricante = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        lblCor = new javax.swing.JLabel();
        cboCor = new javax.swing.JComboBox<>();
        lblPlaca = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        cbDisponivel = new javax.swing.JCheckBox();
        cboFabricante = new javax.swing.JComboBox<>();
        cboModelo = new javax.swing.JComboBox<>();
        lblImg = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        pnlCenter.setForeground(new java.awt.Color(252, 163, 17));
        pnlCenter.setMaximumSize(null);

        lblAno.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblAno.setText("Ano:");

        lblFabricante.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblFabricante.setText("Fabricante");

        txtAno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAnoFocusGained(evt);
            }
        });
        txtAno.addActionListener(this::txtAnoActionPerformed);

        lblModelo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblModelo.setText("Modelo:");

        lblCor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblCor.setText("Cor:");

        cboCor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cboCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "AMARELO", "AZUL", "BEGE", "BRANCA", "CINZA", "DOURADA", "GRENÁ", "LARANJA", "MARROM", "PRATA", "PRETA", "ROSA", "ROXA", "VERDE", "VERMELHA", "FANTASIA" }));

        lblPlaca.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblPlaca.setText("Placa:");

        lblPreco.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblPreco.setText("Preço:");

        cbDisponivel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbDisponivel.setText("Disponivel");

        cboFabricante.setToolTipText("Selecione");
        cboFabricante.setName(""); // NOI18N
        cboFabricante.addItemListener(this::cboFabricanteItemStateChanged);
        cboFabricante.addActionListener(this::cboFabricanteActionPerformed);

        cboModelo.addItemListener(this::cboModeloItemStateChanged);
        cboModelo.addActionListener(this::cboModeloActionPerformed);

        jPanel1.setBackground(new java.awt.Color(15, 15, 15));

        btnSair.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(this::btnSairActionPerformed);

        btnSalvar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(btnSair)
                .add(20, 20, 20)
                .add(btnSalvar)
                .add(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(btnSalvar)
                    .add(btnSair))
                .add(10, 10, 10))
        );

        org.jdesktop.layout.GroupLayout pnlCenterLayout = new org.jdesktop.layout.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(pnlCenterLayout.createSequentialGroup()
                .add(20, 20, 20)
                .add(pnlCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblAno)
                    .add(pnlCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(pnlCenterLayout.createSequentialGroup()
                            .add(lblImg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 255, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(20, 20, 20)
                            .add(pnlCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(lblFabricante)
                                .add(lblModelo)
                                .add(cboFabricante, 0, 200, Short.MAX_VALUE)
                                .add(cboModelo, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .add(pnlCenterLayout.createSequentialGroup()
                            .add(pnlCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, txtAno, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 255, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(pnlCenterLayout.createSequentialGroup()
                                    .add(pnlCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(lblCor)
                                        .add(cboCor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(20, 20, 20)
                                    .add(pnlCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(lblPreco)
                                        .add(txtPreco, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 20, Short.MAX_VALUE)
                            .add(pnlCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(cbDisponivel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(lblPlaca)
                                .add(txtPlaca, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlCenterLayout.createSequentialGroup()
                .add(20, 20, 20)
                .add(pnlCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlCenterLayout.createSequentialGroup()
                        .add(lblFabricante)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cboFabricante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(20, 20, 20)
                        .add(lblModelo)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cboModelo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(lblImg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 141, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(17, 17, 17)
                .add(pnlCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblPlaca)
                    .add(lblAno))
                .add(6, 6, 6)
                .add(pnlCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtPlaca, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtAno, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(pnlCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblCor)
                    .add(lblPreco))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtPreco, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cbDisponivel)
                    .add(cboCor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 74, Short.MAX_VALUE)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        add(pnlCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAnoFocusGained

    }//GEN-LAST:event_txtAnoFocusGained

    private void txtAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoActionPerformed

    private void cboFabricanteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboFabricanteItemStateChanged

    }//GEN-LAST:event_cboFabricanteItemStateChanged

    private void cboFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFabricanteActionPerformed
        fabricanteSelecionado = obterFabricanteSelecionado();
        carregarCboModelo(fabricanteSelecionado);
    }//GEN-LAST:event_cboFabricanteActionPerformed

    private void cboModeloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboModeloItemStateChanged

    }//GEN-LAST:event_cboModeloItemStateChanged

    private void cboModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboModeloActionPerformed
        modeloSelecionado = obterModeloSelecionado();
        mostrarCarro();
    }//GEN-LAST:event_cboModeloActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        Utils.sair(this);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvar();
    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbDisponivel;
    private javax.swing.JComboBox<String> cboCor;
    private javax.swing.JComboBox<String> cboFabricante;
    private javax.swing.JComboBox<String> cboModelo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblFabricante;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables

    
}
