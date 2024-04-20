/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.imrob.locadoraveiculos.gui.cadastro;

import com.imrob.locadoraveiculos.DTO.FabricanteDTO;
import com.imrob.locadoraveiculos.DTO.ModeloDTO;
import com.imrob.locadoraveiculos.Utils.Utils;
import com.imrob.locadoraveiculos.gui.application.Application;
import com.imrob.locadoraveiculos.services.FabricanteService;
import com.imrob.locadoraveiculos.services.ModeloService;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import raven.swing.AvatarIcon;

/**
 *
 * @author Rob
 */
public class CadastroModeloGUI extends javax.swing.JPanel {
    private FabricanteDTO fabricanteSelecionado;
    private Icon icon;
    private BufferedImage imagemSelecionada;
    private String nomeArquivoSelecionado;
    private final String pastaImagens = "imgs/carro/";
    
    public CadastroModeloGUI() {
        initComponents();
        icon = new AvatarIcon(getClass().getResource("/imgs/img_carrodefault.png"), 180, 100, 10);
        lblImagem.setIcon(icon);
        String destino = getClass().getClassLoader().getResource(pastaImagens).getPath();
        System.out.println(destino);
        carregarCboFabricante();
    }
    
    public void carregarCboFabricante() {
        List<FabricanteDTO> lista = new FabricanteService().findAll();
        
        for (FabricanteDTO f : lista) {
            cboFabricante.addItem(f.getNome());
        }
    }
    
    private FabricanteDTO obterFabricanteSelecionado() {
        List<FabricanteDTO> lista = new FabricanteService().findAll();
        
        try {
        String nomeFabricanteSelecionado = cboFabricante.getSelectedItem().toString();
        for (FabricanteDTO fabricante : lista) {
            if (fabricante.getNome().equals(nomeFabricanteSelecionado)) {
                return fabricante;
            }
        }} catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao obter o fabricante selecionado. " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    private void selecionarImagem() {
        JFileChooser fileChooser = new JFileChooser();
        int escolha = fileChooser.showOpenDialog(this);

        if (escolha == JFileChooser.APPROVE_OPTION) {
            File arquivoImagem = fileChooser.getSelectedFile();
            try {
                // Carrega a imagem selecionada
                imagemSelecionada = ImageIO.read(arquivoImagem);
                nomeArquivoSelecionado = arquivoImagem.getName();

                ImageIcon imagem = new ImageIcon(imagemSelecionada);
                lblImagem.setIcon(new AvatarIcon(imagem, 180, 100, 10));
                lblImagemSelecionada.setText(arquivoImagem.getName());
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao selecionar a imagem.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void salvarImagem(Long id) {
        if (imagemSelecionada != null) {
            try {
                // Obter o diretório de destino dentro do projeto
                String caminhoDestino = getClass().getClassLoader().getResource(pastaImagens).getPath();
                File destino = new File(caminhoDestino);
                if (!destino.exists()) {
                    destino.mkdirs();
                }

                // Obter o nome do arquivo original
                File arquivoDestino = new File(destino, Long.toString(id) + "." + getFileExtension(nomeArquivoSelecionado).toLowerCase());

                // Salvar a imagem
                ImageIO.write(imagemSelecionada, getFileExtension(nomeArquivoSelecionado), arquivoDestino);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar a imagem. " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma imagem selecionada.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
   
    private Long salvarModelo() {
        ModeloService service = new ModeloService();
        ModeloDTO modelo = new ModeloDTO();
        
        try {
            modelo.setNome(txtNome.getText());
            modelo.setFabricanteId(fabricanteSelecionado.getId());
            
            Long modeloId = service.save(modelo);
            
            JOptionPane.showMessageDialog(null, "Modelo salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return modeloId;
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar o modelo no sistema: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        return -1L;
    }    
    
    private Boolean camposPreenchidos() {
        if (txtNome.getText().isBlank() ||
            fabricanteSelecionado.equals("SELECIONE")) {
            return false;
        } else {
            return true;
        }
    }
    
//    private void limparDados(){
//        txtNome.setText("");
//        cboFabricante.setSelectedIndex(1);
//        lblImagem.setIcon(icon);
//        imagemSelecionada = null;
//    }


    private String getFileExtension(String nomeArquivo) {
        return nomeArquivo.substring(nomeArquivo.lastIndexOf('.') + 1);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        lblFabricante = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        cboFabricante = new javax.swing.JComboBox<>();
        lblImagem = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnProcurar = new javax.swing.JButton();
        pnlFooter = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        lblImagemSelecionada = new javax.swing.JLabel();

        lblNome.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblNome.setText("Nome:");

        lblFabricante.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblFabricante.setText("Fabricante:");

        cboFabricante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE" }));
        cboFabricante.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cboFabricanteAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cboFabricante.addActionListener(this::cboFabricanteActionPerformed);

        lblImagem.setPreferredSize(new java.awt.Dimension(180, 100));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Imagem:");

        btnProcurar.setText("Procurar...");
        btnProcurar.addActionListener(this::btnProcurarActionPerformed);

        pnlFooter.setBackground(new java.awt.Color(15, 15, 15));

        btnCancelar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnSalvar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        org.jdesktop.layout.GroupLayout pnlFooterLayout = new org.jdesktop.layout.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFooterLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(btnCancelar)
                .add(20, 20, 20)
                .add(btnSalvar)
                .add(12, 12, 12))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFooterLayout.createSequentialGroup()
                .add(12, 12, 12)
                .add(pnlFooterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnCancelar)
                    .add(btnSalvar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFooter, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(lblFabricante)
                    .add(lblNome)
                    .add(jLabel3))
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(btnProcurar)
                    .add(txtNome)
                    .add(lblImagem, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(cboFabricante, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(lblImagemSelecionada, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(lblImagem, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblNome)
                    .add(txtNome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblFabricante)
                    .add(cboFabricante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(btnProcurar))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblImagemSelecionada, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 70, Short.MAX_VALUE)
                .add(pnlFooter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboFabricanteAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cboFabricanteAncestorAdded

    }//GEN-LAST:event_cboFabricanteAncestorAdded

    private void cboFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFabricanteActionPerformed
        fabricanteSelecionado = obterFabricanteSelecionado();
            System.out.println("obteve fabricante");
    }//GEN-LAST:event_cboFabricanteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Utils.sair(this);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        selecionarImagem();
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (camposPreenchidos()){
            if (imagemSelecionada == null) {
                String mensagem = "Você não selecionou uma imagem!\n"
                        + "Tem certeza que quer salvar o modelo sem uma imagem?";
                int resposta = JOptionPane.showConfirmDialog(this, mensagem, "Salvar Imagem", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                // Chama o método para salvar a imagem
                salvarModelo();
                Utils.sair(this);
                } else {
                // Cancela o salvar
                return;
                }
            } else {
                Long modeloId = salvarModelo();
                salvarImagem(modeloId);
                Utils.sair(this);
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Obrigatório preencher todos os campos!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cboFabricante;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblFabricante;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblImagemSelecionada;
    private javax.swing.JLabel lblNome;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
