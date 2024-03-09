/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.imrob.locadoraveiculos.entities;

/**
 *
 * @author imrob
 */
public class Carro {

    private Long id;
    private Long idFabricante;
    private Long idModelo;
    private String placa;
    private String cor;
    private Boolean disponivel;
    private Integer ano;
    private Double valorLocacao;

    public Carro() {
    }

    public Carro(Long idFabricante, Long idModelo, String placa, String cor, Boolean disponivel, Integer ano, Double valorlocacao) {
        this.idFabricante = idFabricante;
        this.idModelo = idModelo;
        this.placa = placa;
        this.cor = cor;
        this.disponivel = disponivel;
        this.ano = ano;
        this.valorLocacao = valorlocacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Long idFabricante) {
        this.idFabricante = idFabricante;
    }

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(Double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", idFabricante=" + idFabricante +
                ", idModelo=" + idModelo +
                ", placa='" + placa + '\'' +
                ", cor='" + cor + '\'' +
                ", disponivel=" + disponivel +
                ", ano=" + ano +
                ", valorLocacao=" + valorLocacao +
                '}';
    }
}
