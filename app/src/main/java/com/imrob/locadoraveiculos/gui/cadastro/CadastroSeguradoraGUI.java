/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.imrob.locadoraveiculos.gui.cadastro;

import com.fasterxml.jackson.databind.JsonNode;
import com.imrob.locadoraveiculos.DTO.EnderecoDTO;
import com.imrob.locadoraveiculos.DTO.SeguradoraDTO;
import com.imrob.locadoraveiculos.Utils.Utils;
import com.imrob.locadoraveiculos.Utils.Validators;
import com.imrob.locadoraveiculos.services.BrasilApiCNPJ;
import com.imrob.locadoraveiculos.services.SeguradoraService;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author Rob
 */
public class CadastroSeguradoraGUI extends javax.swing.JPanel {
    private BrasilApiCNPJ brasilApi;

    /**
     * Creates new form CadastroSeguradoraGUI
     */
    public CadastroSeguradoraGUI() {
        initComponents();
        brasilApi = Feign.builder()
                .decoder(new JacksonDecoder())
                .target(BrasilApiCNPJ.class, "https://brasilapi.com.br");
    }

    void consultarCnpj(String cnpj) {
        SwingWorker<JsonNode, Void> worker = new SwingWorker<>() {
            @Override
            protected JsonNode doInBackground() throws Exception {
                return brasilApi.consultarCNPJ(cnpj);
            }

            @Override
            protected void done() {
                try {
                    JsonNode dados = get();
                    String tipoLogradouro = dados.get("descricao_tipo_de_logradouro").asText() + " ";
                    txtNome.setText(dados.get("razao_social").asText());
                    txtfTelefone.setText(dados.get("ddd_telefone_1").asText());
                    txtfCep.setText(dados.get("cep").asText());
                    txtRua.setText(tipoLogradouro + dados.get("logradouro").asText());
                    txtNumero.setText(dados.get("numero").asText());
                    txtBairro.setText(dados.get("bairro").asText());
                    txtCidade.setText(dados.get("municipio").asText());
                    txtEstado.setText(dados.get("uf").asText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao obter as informa��es do CNPJ: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        worker.execute();
    }

    public List<String> validarCampos() {
        List<String> erros = new ArrayList<>();

        if (!Validators.isCharacters(txtBairro.getText())) {
            erros.add("O campo Bairro é inválido.");
        }
        if (!Validators.isCharacters(txtCidade.getText())) {
            erros.add("O campo Cidade é inválido.");
        }
        if (!Validators.isCharacters(txtNome.getText())) {
            erros.add("O campo Nome é inválido.");
        }
        if (Validators.isEmpty(txtfValor.getText()) || !Validators.isNumber(txtNumero.getText())) {
            erros.add("O campo \"Valor do seguro\" é inválido.");
        }
        if (!Validators.isNumber(txtfCnpj.getText().replaceAll("[^0-9]", ""))) {
            erros.add("O campo CNPJ é inválido.");
        }
        if (!Validators.isValidEmail(txtEmail.getText())) {
            erros.add("O campo Email é inválido.");
        }
        if (!Validators.isCharacters(txtEstado.getText())) {
            erros.add("O campo Estado é inválido.");
        }
        if (!Validators.isNumber(txtNumero.getText())) {
            erros.add("O campo Número é inválido.");
        }
        if (!Validators.isCharacters(txtRua.getText())) {
            erros.add("O campo Rua é inválido.");
        }
        if (!Validators.hasNumberQuantity(txtfCnpj.getText().replaceAll("[^0-9]", ""), 14)) {
            erros.add("O campo CNPJ é inválido.");
        }
        if (!Validators.hasNumberQuantity(txtfCep.getText().replaceAll("[^0-9]", ""), 8)) {
            erros.add("O campo CEP é inválido.");
        }
        if (!Validators.hasNumberQuantity(txtfTelefone.getText().replaceAll("[^0-9]", ""), 10)) {
            erros.add("O campo Telefone é inválido.");
        }

        return erros;
    }

    public void exibirErros(List<String> erros) {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Por favor, corrija os seguintes erros:\n");
        for (String erro : erros) {
            mensagem.append("- ").append(erro).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensagem.toString(), "Erro de validação", JOptionPane.ERROR_MESSAGE);
    }

    private void limparCampos() {
        txtNome.setText("");
        txtfCnpj.setText("");
        txtfValor.setText("");
        txtEmail.setText("");
        txtRua.setText("");
        txtfTelefone.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtEstado.setText("");
        txtfCep.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfTelefone = new javax.swing.JFormattedTextField();
        txtfCep = new javax.swing.JFormattedTextField();
        txtRua = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtfCnpj = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtfValor = new javax.swing.JFormattedTextField();

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel2.setText("Cnpj");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel4.setText("Telefone");

        try {
            txtfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtRua.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

        txtNumero.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel8.setText("CEP");

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel9.setText("Rua");

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel10.setText("Numero");

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel12.setText("Bairro");

        txtBairro.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel11.setText("Cidade");

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel13.setText("Estado");

        txtCidade.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

        txtEstado.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

        try {
            txtfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(this::btnConsultarActionPerformed);

        jLabel5.setText("Valor do seguro");

        txtfValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(btnCancelar)
                        .add(18, 18, 18)
                        .add(btnSalvar))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(txtNome)
                        .add(txtRua)
                        .add(layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup()
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jLabel10)
                                        .add(jLabel11))
                                    .add(49, 49, 49)
                                    .add(jLabel12))
                                .add(jLabel8)
                                .add(jLabel9)
                                .add(txtCidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 181, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup()
                                    .add(20, 20, 20)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(jLabel13)
                                        .add(txtEstado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(layout.createSequentialGroup()
                                    .add(32, 32, 32)
                                    .add(jLabel5))))
                        .add(jLabel2)
                        .add(jLabel1)
                        .add(layout.createSequentialGroup()
                            .add(txtfCnpj, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(btnConsultar))
                        .add(layout.createSequentialGroup()
                            .add(txtNumero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 76, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(18, 18, 18)
                            .add(txtBairro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 226, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup()
                                    .add(jLabel3)
                                    .add(0, 0, Short.MAX_VALUE))
                                .add(txtEmail)
                                .add(txtfCep))
                            .add(20, 20, 20)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jLabel4)
                                .add(txtfTelefone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, txtfValor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(40, 40, 40)
                .add(jLabel2)
                .add(4, 4, 4)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtfCnpj, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnConsultar))
                .add(19, 19, 19)
                .add(jLabel1)
                .add(4, 4, 4)
                .add(txtNome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jLabel4))
                .add(4, 4, 4)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtfTelefone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(jLabel5))
                .add(4, 4, 4)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtfCep, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtfValor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(jLabel9)
                .add(4, 4, 4)
                .add(txtRua, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel10)
                    .add(jLabel12))
                .add(4, 4, 4)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtNumero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtBairro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(jLabel13))
                .add(4, 4, 4)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtCidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtEstado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnSalvar)
                    .add(btnCancelar))
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        consultarCnpj(txtfCnpj.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        List<String> erros = validarCampos();

        if (erros.isEmpty()) {
            EnderecoDTO endereco = new EnderecoDTO(
                    txtRua.getText(),
                    txtNumero.getText(),
                    txtBairro.getText(),
                    txtCidade.getText(),
                    txtEstado.getText(),
                    txtfCep.getText()
            );

            SeguradoraDTO seguradora = new SeguradoraDTO(
                    txtNome.getText(),
                    txtfCnpj.getText().replaceAll("[^0-9]", ""),
                    txtEmail.getText(),
                    Double.parseDouble(txtfValor.getText().replace(",", ".")),
                    txtfTelefone.getText()
            );
            try {
                new SeguradoraService().save(seguradora, endereco);
                JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar a seguradora no sistema: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            exibirErros(erros);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Utils.sair(this);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRua;
    private javax.swing.JFormattedTextField txtfCep;
    private javax.swing.JFormattedTextField txtfCnpj;
    private javax.swing.JFormattedTextField txtfTelefone;
    private javax.swing.JFormattedTextField txtfValor;
    // End of variables declaration//GEN-END:variables
}
