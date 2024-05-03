
package com.imrob.locadoraveiculos.gui.forms.locacao;

import com.imrob.locadoraveiculos.DTO.CarroDTO;
import com.imrob.locadoraveiculos.DTO.LocacaoDTO;
import com.imrob.locadoraveiculos.DTO.SeguradoraDTO;
import com.imrob.locadoraveiculos.gui.forms.LocacaoForm;
import com.imrob.locadoraveiculos.services.SeguradoraService;
import java.awt.Color;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import raven.datetime.component.date.DateEvent;
import raven.datetime.component.date.DatePicker;
import raven.swing.AvatarIcon;

/**
 *
 * @author Rob
 */
public class LocacaoDetalhes extends javax.swing.JPanel {
    private Double valorDiaria = 0.0;
    private Double valorTotalDiaria = 0.0;
    private Double valorSeguro = 0.0;
    private Double valorDesconto = 0.0;
    private Double valorTotal = 0.0;
    private CarroDTO carro;
    private SeguradoraDTO seguradora;
    private LocacaoDTO locacao;
    private DecimalFormat df = new DecimalFormat("#0.00");

    public LocacaoDetalhes() {
        initComponents();
        carro = new CarroDTO();
        seguradora = new SeguradoraDTO();
        pnlSeguradora.setVisible(false);
        pnlResumo.setVisible(false);
        carregarCboSeguradora();
        carregarCalendario();
        lblCupomMsg.setVisible(false);
    }
    
    public void carregarCalendario() {
        DatePicker datePicker = new DatePicker();
        datePicker.setDateSelectionMode(DatePicker.DateSelectionMode.BETWEEN_DATE_SELECTED);
        datePicker.setSeparator(" até ");
        datePicker.setDateSelectionAble(localDate -> localDate.isAfter(LocalDate.now()));
        datePicker.addDateSelectionListener((DateEvent de) -> {
            LocalDate[] datas = datePicker.getSelectedDateRange();
            LocacaoForm.getInstance().getLocacao().setDataLocacao(datas[0]);
            LocacaoForm.getInstance().getLocacao().setDataDevolucao(datas[1]);
            LocacaoForm.getInstance().getLocacao().setDataDevolvida(datas[1]);
            if (datas != null) {
                LocacaoForm.getInstance().getLocacao().setDataLocacao(datas[0]);
                LocacaoForm.getInstance().getLocacao().setDataDevolucao(datas[1]);
                LocacaoForm.getInstance().getLocacao().setDataDevolvida(datas[1]);
                int dias = datas[1].compareTo(datas[0]);
                lblDias.setText(dias + " dias");
                carregarResumo();
                valorTotalDiaria = dias * carro.getValorLocacao();
                lblValorTotalDiarias.setText(String.valueOf(df.format(valorTotalDiaria)));
                pnlResumo.setVisible(true);
                atualizarTotal();
            }
        });
        
        datePicker.setEditor(txtfPeriodo);
        
    }
    
    public void carregarResumo() {
        locacao = LocacaoForm.getInstance().getLocacao();
        carro = LocacaoForm.getInstance().getCarro();
        lblFabricanteECarro.setText(carro.getFabricante() + " " + carro.getModelo());
        lblCliente.setText(LocacaoForm.getInstance().getCliente().getNome());
        lblValorDiaria.setText(String.valueOf(df.format(carro.getValorLocacao())));
        lblValorSeguro.setText(String.valueOf(df.format(valorSeguro)));
        lblValorDesconto.setText(String.valueOf(df.format(valorDesconto)));
        lblImagem.setIcon(new AvatarIcon(getClass().getResource(carro.getImagePath()), 213, 118, 10));
        atualizarTotal();
    }
    
    public void atualizarTotal() {
        valorTotal = (valorTotalDiaria + valorSeguro) - valorDesconto;
        lblTotal.setText("R$ " + String.valueOf(df.format(valorTotal)));
        locacao.setValor(valorTotalDiaria);
        locacao.setValorTotal(valorTotal);
        if (!LocacaoForm.getBtnProximo().isEnabled()){
        LocacaoForm.getBtnProximo().setEnabled(true);
        }
        LocacaoFinalizacao.carregarPainel();
    }
    
    public void carregarCboSeguradora() {
        List<SeguradoraDTO> lista = new SeguradoraService().findAll();
        cboSeguradora.addItem("SELECIONE");
        
        for (SeguradoraDTO f : lista) {
            cboSeguradora.addItem(f.getNome());
        }
    }
    
    private SeguradoraDTO obterSeguradoraSelecionado() {
        List<SeguradoraDTO> lista = new SeguradoraService().findAll();
        
        try {
        String nomeSeguradoraSelecionada = cboSeguradora.getSelectedItem().toString();
        for (SeguradoraDTO seguradora : lista) {
            if (seguradora.getNome().equals(nomeSeguradoraSelecionada)) {
                return seguradora;
            }
        }} catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao obter a seguradora selecionado. " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    private void aplicarDesconto(Double porcentagemDesconto) {
        valorDesconto = valorTotalDiaria * ( porcentagemDesconto/100 );
        lblValorDesconto.setText(String.valueOf(df.format(valorDesconto)));
        lblCupomMsg.setText("Cupom aplicado!");
        lblCupomMsg.setForeground(Color.green);
        lblCupomMsg.setVisible(true);
        LocacaoForm.getInstance().getLocacao().setValorDesconto(valorDesconto);
        atualizarTotal();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rdoSim = new javax.swing.JRadioButton();
        rdoNao = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        pnlSeguradora = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboSeguradora = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtCupom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtfPeriodo = new javax.swing.JFormattedTextField();
        pnlResumo = new javax.swing.JPanel();
        lblImagem = new javax.swing.JLabel();
        lblCarro = new javax.swing.JLabel();
        lblFabricanteECarro = new javax.swing.JLabel();
        lblCarro1 = new javax.swing.JLabel();
        lblCarro2 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblCarro3 = new javax.swing.JLabel();
        lblCarro4 = new javax.swing.JLabel();
        lblValorTotalDiarias = new javax.swing.JLabel();
        lblValorSeguro = new javax.swing.JLabel();
        lblValorDesconto = new javax.swing.JLabel();
        lblCarro5 = new javax.swing.JLabel();
        lblCarro6 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblValorDiaria = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblDias = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblCupomMsg = new javax.swing.JLabel();
        btnAplicar = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("Opcionais");

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel1.setText("Deseja adicionar Seguro?");

        buttonGroup1.add(rdoSim);
        rdoSim.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        rdoSim.setText("Sim");
        rdoSim.addActionListener(this::rdoSimActionPerformed);

        buttonGroup1.add(rdoNao);
        rdoNao.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        rdoNao.setText("Não");
        rdoNao.addActionListener(this::rdoNaoActionPerformed);

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setText("Pagamento");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel3.setText("Selecione a seguradora desejada");

        cboSeguradora.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        cboSeguradora.addActionListener(this::cboSeguradoraActionPerformed);

        org.jdesktop.layout.GroupLayout pnlSeguradoraLayout = new org.jdesktop.layout.GroupLayout(pnlSeguradora);
        pnlSeguradora.setLayout(pnlSeguradoraLayout);
        pnlSeguradoraLayout.setHorizontalGroup(
            pnlSeguradoraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlSeguradoraLayout.createSequentialGroup()
                .add(pnlSeguradoraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(cboSeguradora, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 0, 0))
        );
        pnlSeguradoraLayout.setVerticalGroup(
            pnlSeguradoraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlSeguradoraLayout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jLabel3)
                .add(4, 4, 4)
                .add(cboSeguradora, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0))
        );

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel5.setText("Cupom");

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setText("Periodo de locação");

        lblImagem.setPreferredSize(new java.awt.Dimension(150, 84));

        lblCarro.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblCarro.setText("Carro");

        lblFabricanteECarro.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblFabricanteECarro.setText("fabricante e carro");

        lblCarro1.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblCarro1.setText("Cliente");

        lblCarro2.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblCarro2.setText("Total diarias");

        lblCliente.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblCliente.setText("lblCliente");

        lblCarro3.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblCarro3.setText("Seguro");

        lblCarro4.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblCarro4.setText("Preço diária");

        lblValorTotalDiarias.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblValorTotalDiarias.setText("lblTotal");

        lblValorSeguro.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblValorSeguro.setText("lblTotal");

        lblValorDesconto.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblValorDesconto.setText("lblTotal");

        lblCarro5.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblCarro5.setText("Desconto");

        lblCarro6.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblCarro6.setText("Total");

        lblTotal.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblTotal.setText("lblTotal");

        lblValorDiaria.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblValorDiaria.setText("lblPreco");

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setText("Resumo");

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jLabel9.setText("Diarias");

        lblDias.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblDias.setText("lblDias");

        org.jdesktop.layout.GroupLayout pnlResumoLayout = new org.jdesktop.layout.GroupLayout(pnlResumo);
        pnlResumo.setLayout(pnlResumoLayout);
        pnlResumoLayout.setHorizontalGroup(
            pnlResumoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlResumoLayout.createSequentialGroup()
                .add(21, 21, 21)
                .add(pnlResumoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblImagem, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(pnlResumoLayout.createSequentialGroup()
                        .add(pnlResumoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblCarro)
                            .add(jLabel6)
                            .add(lblCarro2)
                            .add(lblCarro3)
                            .add(lblCarro5)
                            .add(lblCarro6)
                            .add(lblCarro1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(pnlResumoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblFabricanteECarro)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblCliente)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblValorTotalDiarias)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblValorSeguro)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblValorDesconto)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblTotal)))
                    .add(pnlResumoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(pnlResumoLayout.createSequentialGroup()
                            .add(lblCarro4)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(lblValorDiaria))
                        .add(pnlResumoLayout.createSequentialGroup()
                            .add(jLabel9)
                            .add(134, 134, 134)
                            .add(lblDias))))
                .add(17, 17, 17))
        );
        pnlResumoLayout.setVerticalGroup(
            pnlResumoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlResumoLayout.createSequentialGroup()
                .add(lblImagem, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlResumoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblCarro)
                    .add(lblFabricanteECarro))
                .add(4, 4, 4)
                .add(pnlResumoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblCarro1)
                    .add(lblCliente))
                .add(4, 4, 4)
                .add(pnlResumoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel9)
                    .add(lblDias))
                .add(4, 4, 4)
                .add(pnlResumoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblCarro4)
                    .add(lblValorDiaria))
                .add(15, 15, 15)
                .add(jLabel6)
                .add(10, 10, 10)
                .add(pnlResumoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblCarro2)
                    .add(lblValorTotalDiarias))
                .add(4, 4, 4)
                .add(pnlResumoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblCarro3)
                    .add(lblValorSeguro))
                .add(4, 4, 4)
                .add(pnlResumoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblValorDesconto)
                    .add(lblCarro5))
                .add(18, 18, 18)
                .add(pnlResumoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblCarro6)
                    .add(lblTotal))
                .add(15, 15, 15))
        );

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel8.setText("Forma de pagamento");

        jComboBox1.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "DINHEIRO", "PIX", "CARTÃO DE DEBITO", "CARTÃO DE CREDITO" }));

        lblCupomMsg.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        lblCupomMsg.setText("mensagem cupom");

        btnAplicar.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        btnAplicar.setText("Aplicar");
        btnAplicar.addActionListener(this::btnAplicarActionPerformed);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel7)
                    .add(jLabel2)
                    .add(jLabel4)
                    .add(txtfPeriodo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 215, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(rdoSim)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(rdoNao))
                    .add(jLabel1)
                    .add(pnlSeguradora, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5)
                    .add(layout.createSequentialGroup()
                        .add(txtCupom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnAplicar))
                    .add(jLabel8)
                    .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblCupomMsg))
                .add(18, 18, 18)
                .add(pnlResumo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlResumo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(jLabel7)
                        .add(4, 4, 4)
                        .add(txtfPeriodo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(20, 20, 20)
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel1)
                        .add(4, 4, 4)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(rdoSim)
                            .add(rdoNao))
                        .add(4, 4, 4)
                        .add(pnlSeguradora, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(20, 20, 20)
                        .add(jLabel4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel5)
                        .add(4, 4, 4)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtCupom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(btnAplicar))
                        .add(2, 2, 2)
                        .add(lblCupomMsg)
                        .add(20, 20, 20)
                        .add(jLabel8)
                        .add(4, 4, 4)
                        .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSimActionPerformed
        pnlSeguradora.setVisible(true);
    }//GEN-LAST:event_rdoSimActionPerformed

    private void rdoNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNaoActionPerformed
        pnlSeguradora.setVisible(false);
    }//GEN-LAST:event_rdoNaoActionPerformed

    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed
        if (!txtCupom.getText().isEmpty()) {
            switch (txtCupom.getText()) {
                case "QUERO5" -> aplicarDesconto(5.0);
                case "QUERO10" -> aplicarDesconto(10.0);
                case "QUERO15" -> aplicarDesconto(15.0);
                default -> {
                    aplicarDesconto(0.0);
                    lblCupomMsg.setText("Cupom inválido!");
                    lblCupomMsg.setForeground(Color.red);
                }
            }
        }
        atualizarTotal();
    }//GEN-LAST:event_btnAplicarActionPerformed

    private void cboSeguradoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSeguradoraActionPerformed
        if (cboSeguradora.getSelectedIndex() != 0) {
        if (rdoSim.isSelected()){
            seguradora = obterSeguradoraSelecionado();
            valorSeguro = seguradora.getValor();
            lblValorSeguro.setText(String.valueOf(df.format(valorSeguro)));
        } else if (rdoNao.isSelected()){
            lblValorSeguro.setText(String.valueOf(df.format(0)));
            valorSeguro = 0.0;
        }
        atualizarTotal();
        locacao.setSeguradoraId(seguradora.getId());
        }
    }//GEN-LAST:event_cboSeguradoraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboSeguradora;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblCarro;
    private javax.swing.JLabel lblCarro1;
    private javax.swing.JLabel lblCarro2;
    private javax.swing.JLabel lblCarro3;
    private javax.swing.JLabel lblCarro4;
    private javax.swing.JLabel lblCarro5;
    private javax.swing.JLabel lblCarro6;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCupomMsg;
    private javax.swing.JLabel lblDias;
    private javax.swing.JLabel lblFabricanteECarro;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblValorDesconto;
    private javax.swing.JLabel lblValorDiaria;
    private javax.swing.JLabel lblValorSeguro;
    private javax.swing.JLabel lblValorTotalDiarias;
    private javax.swing.JPanel pnlResumo;
    private javax.swing.JPanel pnlSeguradora;
    private javax.swing.JRadioButton rdoNao;
    private javax.swing.JRadioButton rdoSim;
    private javax.swing.JTextField txtCupom;
    private javax.swing.JFormattedTextField txtfPeriodo;
    // End of variables declaration//GEN-END:variables
}
