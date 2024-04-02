
package com.imrob.locadoraveiculos.entities;

public class Carro {

    private Long id;
    // Foi necessario o snakecase devido mapeamento com banco de dados
    private Long fabricante_id;
    private Long modelo_id;
    private String placa;
    private String cor;
    private Boolean disponivel;
    private Integer ano;
    private Double valorlocacao;

    public Carro() {
    }

    public Carro(Long idFabricante, Long idModelo, String placa, String cor, Boolean disponivel, Integer ano, Double valorlocacao) {
        this.fabricante_id = idFabricante;
        this.modelo_id = idModelo;
        this.placa = placa;
        this.cor = cor;
        this.disponivel = disponivel;
        this.ano = ano;
        this.valorlocacao = valorlocacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFabricante_id() {
        return fabricante_id;
    }

    public void setFabricante_id(Long fabricante_id) {
        this.fabricante_id = fabricante_id;
    }

    public Long getModelo_id() {
        return modelo_id;
    }

    public void setModelo_id(Long modelo_id) {
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

    public Double getValorlocacao() {
        return valorlocacao;
    }

    public void setValorlocacao(Double valorlocacao) {
        this.valorlocacao = valorlocacao;
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
                ", valorLocacao=" + valorlocacao +
                '}';
    }
}
