
package com.imrob.locadoraveiculos.DTO;

public class ModeloDTO {
    private Long id;
    private String nome;
    private Long fabricanteId;
    private String fabricante;

    public ModeloDTO() {
    }

    public ModeloDTO(Long id, String nome, Long fabricanteId, String fabricante) {
        this.id = id;
        this.nome = nome;
        this.fabricanteId = fabricanteId;
        this.fabricante = fabricante;
    }

    public Long getFabricanteId() {
        return fabricanteId;
    }

    public void setFabricanteId(Long fabricanteId) {
        this.fabricanteId = fabricanteId;
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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
   
}
