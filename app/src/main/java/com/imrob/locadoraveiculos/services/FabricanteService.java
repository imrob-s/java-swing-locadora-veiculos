package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.entities.Fabricante;
import com.imrob.locadoraveiculos.repositories.FabricanteRepository;
import java.util.List;
import java.util.Optional;

public class FabricanteService {
    private final FabricanteRepository repository;

    public FabricanteService(FabricanteRepository fabricanteRepository) {
        this.repository = fabricanteRepository;
    }

    public List<Fabricante> findAll() {
        return repository.findAll();
    }
    
    public Fabricante findById(Long id) {
        return repository.findBy(id);
    }
    
    public void save(Fabricante fabricante){
        repository.save(fabricante);
    }
    
    public void update(Fabricante fabricante) {
        repository.update(fabricante);
    }
    
    public void delete(Long id) {
        repository.delete(id);
    }
}
