
package com.imrob.locadoraveiculos.gui.forms.locacao;

import com.imrob.locadoraveiculos.DTO.ClienteDTO;
import com.imrob.locadoraveiculos.Utils.Validators;
import com.imrob.locadoraveiculos.gui.forms.LocacaoForm;
import com.imrob.locadoraveiculos.services.ClienteService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Rob
 */
public class LocacaoCliente extends javax.swing.JPanel {
    private ClienteDTO cliente;
    private JButton botaoProximo;

    public LocacaoCliente(JButton botaoProximo) {
        initComponents();
        pnlDadosCliente.setVisible(false);
        botaoProximo.setEnabled(false);
        this.botaoProximo = botaoProximo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        pnlDadosCliente = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblVencimentoCnh = new javax.swing.JLabel();
        lblCnh = new javax.swing.JLabel();
        lblRg = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        btnProcurar = new javax.swing.JButton();

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel5.setText("Digite o CPF do cliente");

        txtCpf.addActionListener(this::txtCpfActionPerformed);
        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCpfKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel11.setText("Telefone");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel4.setText("Nome");

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel8.setText("Vencimento CNH");

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel12.setText("Email");

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel6.setText("RG");

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        jLabel7.setText("CNH");

        lblVencimentoCnh.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblVencimentoCnh.setText("vencimento");

        lblCnh.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblCnh.setText("cnh");

        lblRg.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblRg.setText("rg");

        lblNome.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblNome.setText("nome");

        lblTelefone.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblTelefone.setText("telefone");

        lblEmail.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblEmail.setText("email");

        org.jdesktop.layout.GroupLayout pnlDadosClienteLayout = new org.jdesktop.layout.GroupLayout(pnlDadosCliente);
        pnlDadosCliente.setLayout(pnlDadosClienteLayout);
        pnlDadosClienteLayout.setHorizontalGroup(
            pnlDadosClienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlDadosClienteLayout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(pnlDadosClienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel4)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel6)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel7)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel8)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel11)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel12))
                .add(15, 15, 15)
                .add(pnlDadosClienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblNome)
                    .add(lblRg)
                    .add(lblCnh)
                    .add(lblVencimentoCnh)
                    .add(lblTelefone)
                    .add(lblEmail))
                .add(0, 0, Short.MAX_VALUE))
        );
        pnlDadosClienteLayout.setVerticalGroup(
            pnlDadosClienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlDadosClienteLayout.createSequentialGroup()
                .add(10, 10, 10)
                .add(pnlDadosClienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(lblNome))
                .add(4, 4, 4)
                .add(pnlDadosClienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(lblRg))
                .add(4, 4, 4)
                .add(pnlDadosClienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(lblCnh))
                .add(4, 4, 4)
                .add(pnlDadosClienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(lblVencimentoCnh))
                .add(4, 4, 4)
                .add(pnlDadosClienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(lblTelefone))
                .add(4, 4, 4)
                .add(pnlDadosClienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel12)
                    .add(lblEmail))
                .add(10, 10, 10))
        );

        btnProcurar.setText("Procurar");
        btnProcurar.addActionListener(this::btnProcurarActionPerformed);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(0, 20, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jLabel5)
                    .add(layout.createSequentialGroup()
                        .add(txtCpf, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 167, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(10, 10, 10)
                        .add(btnProcurar))
                    .add(pnlDadosCliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .add(jLabel5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtCpf, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnProcurar))
                .add(19, 19, 19)
                .add(pnlDadosCliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyTyped
        String numCpf = txtCpf.getText();

        if (numCpf.length() >= 11) {
            numCpf = numCpf.substring(0, numCpf.length() - 1).trim();
            txtCpf.setText(numCpf);
        }
    }//GEN-LAST:event_txtCpfKeyTyped

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        if (Validators.hasNumberQuantity(txtCpf.getText(), 11)) {
            try {
                cliente = new ClienteService().findByCpf(txtCpf.getText());
                lblNome.setText(cliente.getNome());
                lblRg.setText(cliente.getRg());
                lblCnh.setText(cliente.getCnh());
                lblVencimentoCnh.setText(cliente.getDataVencimentoCNH().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                lblTelefone.setText(cliente.getTelefone());
                lblEmail.setText(cliente.getEmail());
                
                LocacaoForm.getInstance().setCliente(cliente);
                pnlDadosCliente.setVisible(true);
                if(cliente.getDataVencimentoCNH().isBefore(LocalDate.now())){
                    botaoProximo.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Não é possivel alugar um carro para esse cliente.\nRazão: CNH Vencida!", "Erro de validação", JOptionPane.ERROR_MESSAGE);
                } else {
                botaoProximo.setEnabled(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "CPF não encontrado", "Erro de validação", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "O CPF deve conter 11 numeros", "Erro de validação", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnProcurarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcurar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblCnh;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRg;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblVencimentoCnh;
    private javax.swing.JPanel pnlDadosCliente;
    private javax.swing.JTextField txtCpf;
    // End of variables declaration//GEN-END:variables
}
