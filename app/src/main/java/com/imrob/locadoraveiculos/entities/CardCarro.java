package com.imrob.locadoraveiculos.entities;

import javax.swing.Icon;

public class CardCarro extends Carro {
    
    private Icon image;

    public CardCarro() {
    }

    public CardCarro(Long idFabricante, Long idModelo, String placa, String cor, Boolean disponivel, Integer ano, Double valorlocacao, Icon image) {
        super(idFabricante, idModelo, placa, cor, disponivel, ano, valorlocacao);
        this.image = image;
    }

}
