
package com.imrob.locadoraveiculos.entities;

import com.imrob.locadoraveiculos.repositories.impl.Identifiable;
import java.io.Serializable;
import java.time.LocalDate;

public class Locacao implements Identifiable<Long>, Serializable {
    private Long id;
    private Long seguradora_id;
    private Long carro_id;
    private Long cliente_id;
    private LocalDate datalocacao;
    private LocalDate datadevolucao;
    private LocalDate datadevolvida;
    private Double valordesconto;
    private Double valor;
    private Double valorTotal;

    public Locacao() {
    }

    public Locacao(Long id, Long seguradoraId, Long carroId, Long clientId, LocalDate dataLocacao, LocalDate dataDevolucao, LocalDate dataDevolvida, Double valorDesconto, Double valor, Double valorTotal) {
        this.id = id;
        this.seguradora_id = seguradoraId;
        this.carro_id = carroId;
        this.cliente_id = clientId;
        this.datalocacao = dataLocacao;
        this.datadevolucao = dataDevolucao;
        this.datadevolvida = dataDevolvida;
        this.valordesconto = valorDesconto;
        this.valor = valor;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeguradora_id() {
        return seguradora_id;
    }

    public void setSeguradora_id(Long seguradora_id) {
        this.seguradora_id = seguradora_id;
    }

    public Long getCarro_id() {
        return carro_id;
    }

    public void setCarro_id(Long carro_id) {
        this.carro_id = carro_id;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
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

    public Double getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(Double valordesconto) {
        this.valordesconto = valordesconto;
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
