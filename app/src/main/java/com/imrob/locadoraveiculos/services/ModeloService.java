package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.entities.Modelo;
import com.imrob.locadoraveiculos.repositories.ModeloRepository;
import java.util.List;

public class ModeloService {
    private final ModeloRepository repository;

    public ModeloService(ModeloRepository modeloRepository) {
        this.repository = modeloRepository;
    }

    public List<Modelo> findAll() {
        return repository.findAll();
    }
    
    public Modelo findById(Long id) {
        return repository.findBy(id);
    }
    
    public void save(Modelo modelo) {
        repository.save(modelo);
    }
    
    public void update(Modelo modelo) {
        repository.update(modelo);
    }
    
    public void delete(Long id) {
        repository.delete(id);
    }
}
