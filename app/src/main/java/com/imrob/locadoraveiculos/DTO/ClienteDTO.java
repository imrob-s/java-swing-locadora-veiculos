package com.imrob.locadoraveiculos.DTO;

import java.time.LocalDate;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String rg;
    private String cpf;
    private String cnh;
    private LocalDate dataVencimentoCNH;
    private String email;
    private EnderecoDTO endereco;
    private String telefone;
    private Long enderecoId;
    private static String[] colunas = {"Id", "Nome", "RG", "CPF", "CNH", 
        "Vencimento CNH", "email", "Rua", "Numero", "Bairro", "Cidade", "Estado", "CEP", "Telefone"};

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String nome, String rg, String cpf, String cnh, LocalDate dataVencimentoCNH, String email, EnderecoDTO endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.cnh = cnh;
        this.dataVencimentoCNH = dataVencimentoCNH;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public ClienteDTO(String nome, String rg, String cpf, String cnh, LocalDate dataVencimentoCNH, String email, EnderecoDTO endereco, String telefone) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.cnh = cnh;
        this.dataVencimentoCNH = dataVencimentoCNH;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public ClienteDTO(Long id, String nome, String rg, String cpf, String cnh, LocalDate dataVencimentoCNH, String email, String telefone, Long enderecoId) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.cnh = cnh;
        this.dataVencimentoCNH = dataVencimentoCNH;
        this.email = email;
        this.telefone = telefone;
        this.enderecoId = enderecoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
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

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public static String[] getColunas() {
        return colunas;
    }
    
}