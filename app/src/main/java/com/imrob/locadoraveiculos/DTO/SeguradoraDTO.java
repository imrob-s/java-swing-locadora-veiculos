package com.imrob.locadoraveiculos.DTO;

public class SeguradoraDTO {
    private Long id;
    private String nome;
    private String cnpj;
    private String email;
    private double valor;
    private Long endereco_id;
    private String telefone;

    public SeguradoraDTO() {
    }

    public SeguradoraDTO(Long id, String nome, String cnpj, String email, double valor, Long endereco_id, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.valor = valor;
        this.endereco_id = endereco_id;
        this.telefone = telefone;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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
