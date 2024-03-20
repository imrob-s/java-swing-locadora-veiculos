
package com.imrob.locadoraveiculos.entities;

public class Seguradora {
    private Long id;
    private String nome;
    private String cnpj;
    private String email;
    private Double valor;
    private Long municipio_id;
    private Long estado_id;
    private String telefone;

    public Seguradora() {
    }

    public Seguradora(Long id, String nome, String cnpj, String email, Double valor, Long municipioId, Long estadoId, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.valor = valor;
        this.municipio_id = municipioId;
        this.estado_id = estadoId;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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
