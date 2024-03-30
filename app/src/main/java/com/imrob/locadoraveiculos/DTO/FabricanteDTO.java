
package com.imrob.locadoraveiculos.DTO;

public class FabricanteDTO {
    private Long id;
    private String nome;

    public FabricanteDTO() {
    }

    public FabricanteDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public FabricanteDTO(String nome) {
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
    
    
}
