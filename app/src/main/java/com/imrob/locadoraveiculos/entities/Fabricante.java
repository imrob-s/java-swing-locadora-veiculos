
package com.imrob.locadoraveiculos.entities;

import com.imrob.locadoraveiculos.repositories.impl.Identifiable;

import java.io.Serializable;

public class Fabricante implements Identifiable, Serializable {
    private Long id;
    private String nome;

    public Fabricante() {
    }
    
    public Fabricante(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Fabricante{" + "id=" + id + ", nome=" + nome + '}';
    }
}
