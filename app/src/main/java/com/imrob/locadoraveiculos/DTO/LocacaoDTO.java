package com.imrob.locadoraveiculos.DTO;

import java.time.LocalDate;

public class LocacaoDTO {
    private Long id;
    private Long seguradoraId;
    private Long carroId;
    private Long clientId;
    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private LocalDate dataDevolvida;
    private double valorDesconto;
    private double valor;
    private double valorTotal;

    public LocacaoDTO() {
    }

    public LocacaoDTO(Long id, Long seguradoraId, Long carroId, Long clientId, LocalDate dataLocacao, LocalDate dataDevolucao, LocalDate dataDevolvida, double valorDesconto, double valor, double valorTotal) {
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

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataDevolvida() {
        return dataDevolvida;
    }

    public void setDataDevolvida(LocalDate dataDevolvida) {
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

    @Override
    public String toString() {
        return "LocacaoDTO{" + "id=" + id + ", seguradoraId=" + seguradoraId + ", carroId=" + carroId + ", clientId=" + clientId + ", dataLocacao=" + dataLocacao + ", dataDevolucao=" + dataDevolucao + ", dataDevolvida=" + dataDevolvida + ", valorDesconto=" + valorDesconto + ", valor=" + valor + ", valorTotal=" + valorTotal + '}';
    }
    
    
}
