
package com.imrob.locadoraveiculos.entities;

import com.imrob.locadoraveiculos.repositories.impl.Identifiable;
import java.io.Serializable;
import java.time.LocalDate;

public class Locacao implements Identifiable<Long>, Serializable {
    private Long id;
    private Long seguradoraId;
    private Long carroId;
    private Long clientId;
    private LocalDate datalocacao;
    private LocalDate datadevolucao;
    private LocalDate datadevolvida;
    private Double valorDesconto;
    private Double valor;
    private Double valorTotal;

    public Locacao() {
    }

    public Locacao(Long id, Long seguradoraId, Long carroId, Long clientId, LocalDate dataLocacao, LocalDate dataDevolucao, LocalDate dataDevolvida, Double valorDesconto, Double valor, Double valorTotal) {
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

    public LocalDate getDatalocacao() {
        return datalocacao;
    }

    public void setDatalocacao(LocalDate datalocacao) {
        this.datalocacao = datalocacao;
    }

    public LocalDate getDatadevolucao() {
        return datadevolucao;
    }

    public void setDatadevolucao(LocalDate datadevolucao) {
        this.datadevolucao = datadevolucao;
    }

    public LocalDate getDatadevolvida() {
        return datadevolvida;
    }

    public void setDatadevolvida(LocalDate datadevolvida) {
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
