package com.imrob.locadoraveiculos.entities;

public class Municipio {
    private Long id;
    private String nome;
    private Long estado_id;
    private String estado_nome;

    public Municipio() {
    }

    public Municipio(Long id, String nome, Long estadoId, String estadoNome) {
        this.id = id;
        this.nome = nome;
        this.estado_id = estadoId;
        this.estado_nome = estadoNome;
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

    public Long getEstadoId() {
        return estado_id;
    }

    public void setEstadoId(Long estadoId) {
        this.estado_id = estadoId;
    }

    public String getEstadoNome() {
        return estado_nome;
    }

    public void setEstadoNome(String estadoNome) {
        this.estado_nome = estadoNome;
    }
}
