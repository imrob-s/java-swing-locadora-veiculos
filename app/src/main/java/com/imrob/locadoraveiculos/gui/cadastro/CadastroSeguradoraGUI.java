/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.imrob.locadoraveiculos.gui.cadastro;

import com.fasterxml.jackson.databind.JsonNode;
import com.imrob.locadoraveiculos.DTO.EnderecoDTO;
import com.imrob.locadoraveiculos.DTO.SeguradoraDTO;
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
        if (Validators.isEmpty(txtfValor.getText()) || 
                !Validators.isNumber(txtNumero.getText())) {
            erros.add("O campo \"Valor do seguro\" é inválido.");
        }
        if (!Validators.isNumber(txtfCnpj.getText()
                .replaceAll("[^0-9]", ""))) {
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
        if (!Validators.hasNumberQuantity(txtfCnpj.getText()
                .replaceAll("[^0-9]", ""), 14)) {
            erros.add("O campo CNPJ é inválido.");
        }
        if (!Validators.hasNumberQuantity(txtfCep.getText()
                .replaceAll("[^0-9]", ""), 8)) {
            erros.add("O campo CEP é inválido.");
        }
        if (!Validators.hasNumberQuantity(txtfTelefone.getText()
                .replaceAll("[^0-9]", ""), 10)) {
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

        crazyPanel = new raven.crazypanel.CrazyPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtfCnpj = new javax.swing.JFormattedTextField();
        btnConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfTelefone = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtfCep = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtfValor = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();

        crazyPanel.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "",
            new String[]{
                "font:bold +10",
                "font:bold +1"
            }
        ));
        crazyPanel.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap 2,fillx,insets 25",
            "[grow 0,trail]15[fill]",
            "",
            new String[]{
                "wrap,al lead",
                "wrap,al lead",
                "wrap,al lead",
                "",
                "split 2",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "span 2,al trail"
            }
        ));

        jLabel6.setText("Seguradora");
        crazyPanel.add(jLabel6);

        jLabel7.setText("Cadastro");
        crazyPanel.add(jLabel7);

        jLabel14.setText("Informações da empresa");
        crazyPanel.add(jLabel14);

        jLabel15.setText("CNPJ");
        crazyPanel.add(jLabel15);

        try {
            txtfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        crazyPanel.add(txtfCnpj);

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(this::btnConsultarActionPerformed);
        crazyPanel.add(btnConsultar);

        jLabel1.setText("Nome");
        crazyPanel.add(jLabel1);
        crazyPanel.add(txtNome);

        jLabel3.setText("Email");
        crazyPanel.add(jLabel3);
        crazyPanel.add(txtEmail);

        jLabel4.setText("Telefone");
        crazyPanel.add(jLabel4);

        try {
            txtfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        crazyPanel.add(txtfTelefone);

        jLabel9.setText("Rua");
        crazyPanel.add(jLabel9);

        txtRua.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        crazyPanel.add(txtRua);

        jLabel10.setText("Numero");
        crazyPanel.add(jLabel10);
        crazyPanel.add(txtNumero);

        jLabel12.setText("Bairro");
        crazyPanel.add(jLabel12);

        txtBairro.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        crazyPanel.add(txtBairro);

        jLabel11.setText("Cidade");
        crazyPanel.add(jLabel11);
        crazyPanel.add(txtCidade);

        jLabel13.setText("Estado");
        crazyPanel.add(jLabel13);
        crazyPanel.add(txtEstado);

        jLabel8.setText("CEP");
        crazyPanel.add(jLabel8);

        try {
            txtfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        crazyPanel.add(txtfCep);

        jLabel5.setText("Valor do seguro");
        crazyPanel.add(jLabel5);

        txtfValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        crazyPanel.add(txtfValor);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);
        crazyPanel.add(btnSalvar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(crazyPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(crazyPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addContainerGap())
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnSalvar;
    private raven.crazypanel.CrazyPanel crazyPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
