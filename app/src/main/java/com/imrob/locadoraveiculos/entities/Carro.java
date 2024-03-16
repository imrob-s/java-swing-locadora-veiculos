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
    // Foi necessario o snakecase devido mapeamento com banco de dados
    private Long fabricante_id;
    private Long modelo_id;
    private String placa;
    private String cor;
    private Boolean disponivel;
    private Integer ano;
    private Double valorLocacao;
    private String fabricante;
    private String modelo;

    public Carro() {
    }

    public Carro(Long idFabricante, Long idModelo, String placa, String cor, Boolean disponivel, Integer ano, Double valorlocacao) {
        this.fabricante_id = idFabricante;
        this.modelo_id = idModelo;
        this.placa = placa;
        this.cor = cor;
        this.disponivel = disponivel;
        this.ano = ano;
        this.valorLocacao = valorlocacao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFabricanteId() {
        return fabricante_id;
    }

    public void setFabricanteId(Long fabricante_id) {
        this.fabricante_id = fabricante_id;
    }

    public Long getModeloId() {
        return modelo_id;
    }

    public void setModeloId(Long modelo_id) {
        this.modelo_id = modelo_id;
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
                ", idFabricante=" + fabricante_id +
                ", idModelo=" + modelo_id +
                ", placa='" + placa + '\'' +
                ", cor='" + cor + '\'' +
                ", disponivel=" + disponivel +
                ", ano=" + ano +
                ", valorLocacao=" + valorLocacao +
                '}';
    }
}
