package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.entities.Carro;
import com.imrob.locadoraveiculos.entities.Fabricante;
import com.imrob.locadoraveiculos.entities.Modelo;
import com.imrob.locadoraveiculos.repositories.CarroRepository;
import java.util.List;

public class CarroService {
    private final CarroRepository repository;

    public CarroService(CarroRepository modeloRepository) {
        this.repository = modeloRepository;
    }

    public List<Carro> findAll() {
        return repository.findAll();
    }
    
    public Carro findById(Long id) {
        return repository.findById(id);
    }
    
    public void save(Carro carro) {
        repository.save(carro);
    }
    
    public void update(Carro carro) {
        repository.update(carro);
    }
    
    public void delete(Long id) {
        repository.delete(id);
    }
    
    public List<Carro> findAllBy(Fabricante fabricante){
        return repository.findAllBy(fabricante);
    }
    
    public List<Carro> findAllBy(Modelo modelo){
        return repository.findAllBy(modelo);
    }
    
    public List<Carro> findAllWithIdNames(){
        return repository.findAllWithIdNames();
    }
}
