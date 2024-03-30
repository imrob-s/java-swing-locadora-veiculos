
package com.imrob.locadoraveiculos.gui.forms;

import com.imrob.locadoraveiculos.DTO.CarroDTO;
import com.imrob.locadoraveiculos.gui.application.Application;
import com.imrob.locadoraveiculos.gui.cadastro.CadastroCarroGUI;
import com.imrob.locadoraveiculos.gui.components.CardCarro;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class CatalogoVeiculos extends javax.swing.JPanel {
    private CardCarro card;
    private JPanel jpConteudo;
    private JScrollPane scroll;
    
    public CatalogoVeiculos() {
        initComponents();
        carregarTela();
        carregarCatalogoCarros();  
    }
    
//    public void carregarCatalogoCarros() {
//        List<CarroDTO> lista = Application.listaCarro;
//        
//        for (CarroDTO c : lista) {
//            jpConteudo.add(new CardCarro(c));
//        }
//    }
    
    public void carregarCatalogoCarros() {
    String filtro = txtPesquisar.getText();
    jpConteudo.removeAll(); // Remove todos os itens do painel de conteúdo

    // Lista de carros filtrada com base no texto de filtro
    List<CarroDTO> carrosFiltrados = Application.listaCarro.stream()
            .filter(carro ->
                    carro.getNome().toLowerCase().contains(filtro.toLowerCase()) ||
                    carro.getFabricante().toLowerCase().contains(filtro.toLowerCase()) ||
                    carro.getCor().toLowerCase().contains(filtro.toLowerCase()) ||
                    carro.getPlaca().toLowerCase().contains(filtro.toLowerCase()) ||
                    String.valueOf(carro.getValorLocacao()).toLowerCase().contains(filtro.toLowerCase()) ||
                    String.valueOf(carro.getDisponivel()).toLowerCase().contains(filtro.toLowerCase()))
            .collect(Collectors.toList());

    for (CarroDTO c : carrosFiltrados) {
        jpConteudo.add(new CardCarro(c)); // Adiciona cada carro filtrado como um CardCarro ao painel de conteúdo
    }

    // Atualiza o layout do painel de conteúdo para refletir as mudanças
    jpConteudo.revalidate();
    jpConteudo.repaint();
}

    
    public void carregarTela() {
        jpConteudo = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        scroll.setViewportView(jpConteudo);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(10);
        add(scroll, java.awt.BorderLayout.CENTER); 
        
        setPreferredSize(new Dimension(885, 1000));
        GridLayout gridLayout = new GridLayout(0, 4, 15, 15); // 3 colunas, 10 pixels de espaçamento horizontal e vertical
        jpConteudo.setLayout(gridLayout);
        jpConteudo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 30));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();

        setBackground(new java.awt.Color(15, 15, 15));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("Frota de Veículos");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Pesquisar:");

        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyTyped(evt);
            }
        });

        btnAdicionar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnAdicionar.setText("Adicionar Novo");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pHeaderLayout = new javax.swing.GroupLayout(pHeader);
        pHeader.setLayout(pHeaderLayout);
        pHeaderLayout.setHorizontalGroup(
            pHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHeaderLayout.createSequentialGroup()
                .addGroup(pHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHeaderLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionar))
                    .addGroup(pHeaderLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        pHeaderLayout.setVerticalGroup(
            pHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHeaderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar)
                    .addComponent(jLabel2))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        add(pHeader, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        new CadastroCarroGUI().setVisible(true);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarActionPerformed

    private void txtPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyTyped
        carregarCatalogoCarros();
    }//GEN-LAST:event_txtPesquisarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pHeader;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
