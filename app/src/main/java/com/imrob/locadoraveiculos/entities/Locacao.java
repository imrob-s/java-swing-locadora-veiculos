
package com.imrob.locadoraveiculos.entities;

import com.imrob.locadoraveiculos.repositories.impl.Identifiable;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Locacao implements Identifiable, Serializable {
    private Long id;
    private Long seguradoraId;
    private Long carroId;
    private Long clientId;
    private LocalDateTime datalocacao;
    private LocalDateTime datadevolucao;
    private LocalDateTime datadevolvida;
    private Double valorDesconto;
    private Double valor;
    private Double valorTotal;

    public Locacao() {
    }

    public Locacao(Long id, Long seguradoraId, Long carroId, Long clientId, LocalDateTime dataLocacao, LocalDateTime dataDevolucao, LocalDateTime dataDevolvida, Double valorDesconto, Double valor, Double valorTotal) {
        this.id = id;
        this.seguradoraId = seguradoraId;
        this.carroId = carroId;
        this.clientId = clientId;
        this.datalocacao = dataLocacao;
        this.datadevolucao = dataDevolucao;
        this.datadevolvida = dataDevolvida;
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

    public LocalDateTime getDatalocacao() {
        return datalocacao;
    }

    public void setDatalocacao(LocalDateTime datalocacao) {
        this.datalocacao = datalocacao;
    }

    public LocalDateTime getDatadevolucao() {
        return datadevolucao;
    }

    public void setDatadevolucao(LocalDateTime datadevolucao) {
        this.datadevolucao = datadevolucao;
    }

    public LocalDateTime getDatadevolvida() {
        return datadevolvida;
    }

    public void setDatadevolvida(LocalDateTime datadevolvida) {
        this.datadevolvida = datadevolvida;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
