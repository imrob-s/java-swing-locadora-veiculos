package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.entities.Fabricante;
import com.imrob.locadoraveiculos.repositories.FabricanteRepository;
import java.util.List;

public class FabricanteService {
    private final FabricanteRepository repository;

    public FabricanteService(FabricanteRepository fabricanteRepository) {
        this.repository = fabricanteRepository;
    }

    public List<Fabricante> findAll() {
        return repository.findAll();
    }
}
