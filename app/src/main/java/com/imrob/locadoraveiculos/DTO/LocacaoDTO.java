package com.imrob.locadoraveiculos.DTO;

import java.time.LocalDateTime;

public class LocacaoDTO {
    private Long id;
    private Long seguradoraId;
    private Long carroId;
    private Long clientId;
    private LocalDateTime dataLocacao;
    private LocalDateTime dataDevolucao;
    private LocalDateTime dataDevolvida;
    private double valorDesconto;
    private double valor;
    private double valorTotal;

    public LocacaoDTO() {
    }

    public LocacaoDTO(Long id, Long seguradoraId, Long carroId, Long clientId, LocalDateTime dataLocacao, LocalDateTime dataDevolucao, LocalDateTime dataDevolvida, double valorDesconto, double valor, double valorTotal) {
        this.id = id;
        this.seguradoraId = seguradoraId;
        this.carroId = carroId;
        this.clientId = clientId;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.dataDevolvida = dataDevolvida;
        this.valorDesconto = valorDesconto;
        this.valor = valor;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeguradoraId() {
        return seguradoraId;
    }

    public void setSeguradoraId(Long seguradoraId) {
        this.seguradoraId = seguradoraId;
    }

    public Long getCarroId() {
        return carroId;
    }

    public void setCarroId(Long carroId) {
        this.carroId = carroId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDateTime dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDateTime getDataDevolvida() {
        return dataDevolvida;
    }

    public void setDataDevolvida(LocalDateTime dataDevolvida) {
        this.dataDevolvida = dataDevolvida;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
