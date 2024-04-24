package com.imrob.locadoraveiculos.gui.editar;

import com.fasterxml.jackson.databind.JsonNode;
import com.imrob.locadoraveiculos.DTO.ClienteDTO;
import com.imrob.locadoraveiculos.DTO.EnderecoDTO;
import com.imrob.locadoraveiculos.Utils.Utils;
import com.imrob.locadoraveiculos.Utils.Validators;
import com.imrob.locadoraveiculos.services.ClienteService;
import com.imrob.locadoraveiculos.services.EnderecoService;
import com.imrob.locadoraveiculos.services.ViaCEP;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class EditarClienteGUI extends javax.swing.JPanel {
    private ClienteDTO cliente;
    private ViaCEP viacep;

    public EditarClienteGUI(ClienteDTO cliente) {
        initComponents();
        this.cliente = cliente;
        viacep = Feign.builder()
                .decoder(new JacksonDecoder())
                .target(ViaCEP.class, "https://viacep.com.br");
        preencherFormulario();
    }
    
    private void preencherFormulario(){
        Long idEndereco = cliente.getEnderecoId();
        EnderecoDTO endereco = new EnderecoService().findById(idEndereco);
        cliente.setEndereco(endereco);

        txtNome.setText(cliente.getNome());
        txtCpf.setText(cliente.getCpf());
        txtRg.setText(cliente.getRg());
        txtCnh.setText(cliente.getCnh());
        txtRua.setText(cliente.getEndereco().getRua());
        txtNumero.setText(cliente.getEndereco().getNumero());
        txtBairro.setText(cliente.getEndereco().getBairro());
        txtCidade.setText(cliente.getEndereco().getCidade());
        txtEstado.setText(cliente.getEndereco().getEstado());
        txtfCep.setText(cliente.getEndereco().getCep());
        txtfTelefone.setText(cliente.getTelefone());
        txtEmail.setText(cliente.getEmail());
        txtfVencimento.setText(cliente.getDataVencimentoCNH().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    void consultarCep(String cep) {
        SwingWorker<JsonNode, Void> worker = new SwingWorker<>() {
            @Override
            protected JsonNode doInBackground() throws Exception {
                return viacep.consultarCEP(cep);
            }

            @Override
            protected void done() {
                try {
                    JsonNode endereco = get();
                    txtRua.setText(endereco.get("logradouro").asText());
                    txtBairro.setText(endereco.get("bairro").asText());
                    txtCidade.setText(endereco.get("localidade").asText());
                    txtEstado.setText(endereco.get("uf").asText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao obter as informações do Cep: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
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
        if (!Validators.isNumber(txtCnh.getText())) {
            erros.add("O campo CNH é inválido.");
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
        if (!Validators.isNumber(txtRg.getText())) {
            erros.add("O campo RG é inválido.");
        }
        if (!Validators.isCharacters(txtRua.getText())) {
            erros.add("O campo Rua é inválido.");
        }
        if (!Validators.hasNumberQuantity(txtCpf.getText(), 11)) {
            erros.add("O campo CPF é inválido.");
        }
        if (!Validators.hasNumberQuantity(txtfCep.getText().replaceAll("[^0-9]", ""), 8)) {
            erros.add("O campo CEP é inválido.");
        }
        if (!Validators.hasNumberQuantity(txtfTelefone.getText().replaceAll("[^0-9]", ""), 11)) {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCnh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtfVencimento = new javax.swing.JFormattedTextField();
        btnProximo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        txtfTelefone = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnAnterior = new javax.swing.JButton();
        btnConsultarCep = new javax.swing.JButton();
        txtfCep = new javax.swing.JFormattedTextField();

        painel.setFont(new java.awt.Font("Roboto Medium", 0, 13)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel1.setText("Nome");

        txtNome.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel2.setText("CPF");

        txtCpf.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCpfKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel3.setText("RG");

        txtRg.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        txtRg.addActionListener(this::txtRgActionPerformed);

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel4.setText("CNH");

        txtCnh.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel5.setText("Vencimento");

        try {
            txtfVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnProximo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnProximo.setText("Próximo");
        btnProximo.addActionListener(this::btnProximoActionPerformed);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(btnProximo)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(jLabel3)
                        .add(txtRg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel2)
                        .add(txtCpf, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel1)
                        .add(txtNome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jLabel4)
                                .add(txtCnh, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(20, 20, 20)
                            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jLabel5)
                                .add(txtfVencimento)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(40, 40, 40)
                .add(jLabel1)
                .add(4, 4, 4)
                .add(txtNome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(jLabel2)
                .add(4, 4, 4)
                .add(txtCpf, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(jLabel3)
                .add(4, 4, 4)
                .add(txtRg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jLabel5))
                .add(4, 4, 4)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtCnh, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtfVencimento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(btnProximo)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painel.addTab("Dados Pessoais", jPanel1);

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel6.setText("Telefone");

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel7.setText("Email");

        txtEmail.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel8.setText("CEP");

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel9.setText("Rua");

        txtRua.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

        try {
            txtfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnSalvar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnSalvar.setText("Atualizar");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel10.setText("Numero");

        txtNumero.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel12.setText("Bairro");

        txtBairro.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel11.setText("Cidade");

        txtCidade.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

        txtEstado.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel13.setText("Estado");

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(this::btnAnteriorActionPerformed);

        btnConsultarCep.setText("Consultar");
        btnConsultarCep.addActionListener(this::btnConsultarCepActionPerformed);

        try {
            txtfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(btnAnterior)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(btnSalvar))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtEmail, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtRua)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel8)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel7)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel6)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel9)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel10)
                            .add(txtNumero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel11))
                        .add(20, 20, 20)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtBairro)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel12)
                                .add(0, 0, Short.MAX_VALUE))))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(txtCidade)
                        .add(20, 20, 20)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel13)
                            .add(txtEstado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtfTelefone)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
                        .add(txtfCep, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(btnConsultarCep)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(40, 40, 40)
                .add(jLabel6)
                .add(4, 4, 4)
                .add(txtfTelefone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(19, 19, 19)
                .add(jLabel7)
                .add(4, 4, 4)
                .add(txtEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(jLabel8)
                .add(4, 4, 4)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnConsultarCep)
                    .add(txtfCep, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(jLabel9)
                .add(4, 4, 4)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(txtRua, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(20, 20, 20)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel10)
                            .add(jLabel12))
                        .add(4, 4, 4)
                        .add(txtNumero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(txtBairro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel11)
                            .add(jLabel13))
                        .add(4, 4, 4)
                        .add(txtCidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, txtEstado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(39, 39, 39)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnSalvar)
                    .add(btnAnterior))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        painel.addTab("Contato", jPanel2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        painel.setSelectedIndex(1);
    }//GEN-LAST:event_btnProximoActionPerformed

    private void txtCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyTyped
        String numCpf = txtCpf.getText();

        if (numCpf.length() >= 11) {
            numCpf = numCpf.substring(0, numCpf.length() - 1).trim();
            txtCpf.setText(numCpf);
        }
    }//GEN-LAST:event_txtCpfKeyTyped

    private void btnConsultarCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarCepActionPerformed
        consultarCep(txtfCep.getText());
    }//GEN-LAST:event_btnConsultarCepActionPerformed

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

            ClienteDTO cliente = new ClienteDTO(
                    this.cliente.getId(),
                    txtNome.getText(),
                    txtRg.getText(),
                    txtCpf.getText(),
                    txtCnh.getText(),
                    LocalDate.parse(txtfVencimento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    txtEmail.getText(),
                    endereco,
                    txtfTelefone.getText()
            );
            try {
                new ClienteService().update(cliente);
                JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                Utils.sair(this);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar o cliente no sistema: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            exibirErros(erros);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
       painel.setSelectedIndex(0);
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void txtRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRgActionPerformed
        String numRG = txtRg.getText();

        if (numRG.length() >= 9) {
            numRG = numRG.substring(0, numRG.length() - 1).trim();
            txtRg.setText(numRG);
        }
    }//GEN-LAST:event_txtRgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnConsultarCep;
    private javax.swing.JButton btnProximo;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane painel;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCnh;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtRua;
    private javax.swing.JFormattedTextField txtfCep;
    private javax.swing.JFormattedTextField txtfTelefone;
    private javax.swing.JFormattedTextField txtfVencimento;
    // End of variables declaration//GEN-END:variables
}
