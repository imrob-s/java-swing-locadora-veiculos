package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.entities.Fabricante;
import com.imrob.locadoraveiculos.entities.Modelo;
import com.imrob.locadoraveiculos.repositories.FabricanteRepository;
import com.imrob.locadoraveiculos.repositories.ModeloRepository;
import java.util.List;
import java.util.Optional;

public class ModeloService {
    private final ModeloRepository repository;

    public ModeloService(ModeloRepository modeloRepository) {
        this.repository = modeloRepository;
    }

    public List<Modelo> findAll() {
        return repository.findAll();
    }
    
    public Optional<Modelo> findById(long id) {
        return repository.findBy(id);
    }
}
