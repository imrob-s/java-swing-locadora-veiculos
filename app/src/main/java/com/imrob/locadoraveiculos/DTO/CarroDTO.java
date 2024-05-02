package com.imrob.locadoraveiculos.DTO;

public class CarroDTO {
    
    private Long id;
    private Long fabricanteId;
    private Long modeloId;
    private String imagePath;
    private String modelo;
    private String fabricante;
    private Integer ano;
    private String cor;
    private String placa;
    private Boolean disponivel;
    private double valorLocacao;
    
    public CarroDTO() {
    }

    public CarroDTO(Long Id, Long fabricanteId, Long modeloId, String imagePath, String nome, String fabricante, Integer ano, String cor, String placa, Boolean disponivel, double valorLocacao) {
        this.id = Id;
        this.fabricanteId = fabricanteId;
        this.modeloId = modeloId;
        this.imagePath = imagePath;
        this.modelo = nome;
        this.fabricante = fabricante;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
        this.disponivel = disponivel;
        this.valorLocacao = valorLocacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public Long getFabricanteId() {
        return fabricanteId;
    }

    public void setFabricanteId(Long fabricanteId) {
        this.fabricanteId = fabricanteId;
    }

    public Long getModeloId() {
        return modeloId;
    }

    public void setModeloId(Long modeloId) {
        this.modeloId = modeloId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String image) {
        this.imagePath = image;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    @Override
    public String toString() {
        return "CarroDTO{" +
                "id=" + id +
                ", nome='" + modelo + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }
}
