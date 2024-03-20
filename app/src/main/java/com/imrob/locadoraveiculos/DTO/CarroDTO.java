package com.imrob.locadoraveiculos.DTO;

import javax.swing.Icon;

public class CarroDTO {
    
    private Icon image;
    private String nome;
    private String fabricante;
    private String ano;
    private String cor;
    private String placa;
    private Boolean disponibilidade;
    
    public CarroDTO() {
    }

    public CarroDTO(Icon image, String nome, String fabricante, String ano, String cor, String placa, Boolean disponibilidade) {
        this.image = image;
        this.nome = nome;
        this.fabricante = fabricante;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
        this.disponibilidade = disponibilidade;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
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

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

}
