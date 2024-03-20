package com.imrob.locadoraveiculos.DTO;

import com.imrob.locadoraveiculos.entities.Cliente;

import java.time.LocalDate;

public class ClienteDTO {
    private String nome;
    private String rg;
    private String cpf;
    private String cnh;
    private LocalDate dataVencimentoCNH;
    private String email;
    private String logradouro;
    private String municipio;
    private String estado;
    private String telefone;

    public ClienteDTO() {
    }

    public ClienteDTO(String nome, String rg, String cpf, String cnh, LocalDate dataVencimentoCNH, String email, String logradouro, String municipio, String estado, String telefone) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.cnh = cnh;
        this.dataVencimentoCNH = dataVencimentoCNH;
        this.email = email;
        this.logradouro = logradouro;
        this.municipio = municipio;
        this.estado = estado;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public LocalDate getDataVencimentoCNH() {
        return dataVencimentoCNH;
    }

    public void setDataVencimentoCNH(LocalDate dataVencimentoCNH) {
        this.dataVencimentoCNH = dataVencimentoCNH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}