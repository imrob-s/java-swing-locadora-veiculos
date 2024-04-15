/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.imrob.locadoraveiculos.entities;

import com.imrob.locadoraveiculos.repositories.impl.Identifiable;

import java.io.Serializable;

/**
 *
 * @author imrob
 */
public class Modelo implements Identifiable<Long>, Serializable {

    private Long id;
    private String nome;
    private Long fabricante_id;

    public Modelo() {
    }

    public Modelo(Long id, String nome, Long idFabricante) {
        this.id = id;
        this.nome = nome;
        this.fabricante_id = idFabricante;
    }

    public Modelo(String nome, Long idFabricante) {
        this.nome = nome;
        this.fabricante_id = idFabricante;
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

    public Long getFabricante_id() {
        return fabricante_id;
    }

    public void setFabricante_id(Long fabricanteId) {
        this.fabricante_id = fabricanteId;
    }

    @Override
    public String toString() {
        return id + " - " + nome;
    }

}
