
package com.imrob.locadoraveiculos.entities;

import com.imrob.locadoraveiculos.repositories.impl.Identifiable;

import java.io.Serializable;
import java.time.LocalDate;

public class Cliente implements Identifiable, Serializable {
    private Long id;
    private String nome;
    private String rg;
    private String cpf;
    private String cnh;
    private LocalDate cnh_vencimento; // está mapeado com o banco de dados
    private String email;
    private Long endereco_id; // está mapeado com o banco de dados
    private String telefone;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String rg, String cpf, String cnh, 
            LocalDate dataVencimentoCNH, String email, String telefone, Long endereco_id) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.cnh = cnh;
        this.cnh_vencimento = dataVencimentoCNH;
        this.email = email;
        this.telefone = telefone;
        this.endereco_id = endereco_id;
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

    public LocalDate getCnhVencimento() {
        return cnh_vencimento;
    }

    public void setCnhVencimento(LocalDate cnh_vencimento) {
        this.cnh_vencimento = cnh_vencimento;
    }

    public Long getEnderecoId() {
        return endereco_id;
    }

    public void setEnderecoId(Long endereco_id) {
        this.endereco_id = endereco_id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
