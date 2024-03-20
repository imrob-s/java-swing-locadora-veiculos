
package com.imrob.locadoraveiculos.entities;

import java.time.LocalDate;

public class Cliente {
    private Long id;
    private String nome;
    private String rg;
    private String cpf;
    private String cnh;
    private LocalDate cnh_vencimento;
    private String email;
    private String logradouro;
    private Long municipio_id;
    private Long estado_id;
    private String telefone;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String rg, String cpf, String cnh, 
            LocalDate dataVencimentoCNH, String email, String endereco, 
            Long municipioId, Long estadoId, String telefone) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.cnh = cnh;
        this.cnh_vencimento = dataVencimentoCNH;
        this.email = email;
        this.logradouro = endereco;
        this.municipio_id = municipioId;
        this.estado_id = estadoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return cnh_vencimento;
    }

    public void setDataVencimentoCNH(LocalDate dataVencimentoCNH) {
        this.cnh_vencimento = dataVencimentoCNH;
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

    public Long getMunicipioId() {
        return municipio_id;
    }

    public void setMunicipioId(Long municipioId) {
        this.municipio_id = municipioId;
    }

    public Long getEstadoId() {
        return estado_id;
    }

    public void setEstadoId(Long estadoId) {
        this.estado_id = estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
