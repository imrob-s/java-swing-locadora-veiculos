package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.DTO.CarroDTO;
import com.imrob.locadoraveiculos.entities.Carro;
import com.imrob.locadoraveiculos.entities.Fabricante;
import com.imrob.locadoraveiculos.entities.Modelo;
import com.imrob.locadoraveiculos.repositories.CarroRepository;
import java.util.ArrayList;
import java.util.List;

public class CarroService {
    private final CarroRepository repository;
    
    public CarroService() {
        repository = new CarroRepository();
    }

    public List<CarroDTO> findAll() {
        return convertToDTOs(repository.findAll());
    }
    
    public CarroDTO findBy(Long id) {
        return convertToDTO(repository.findBy(id));
    }
    
    public void save(CarroDTO dto) {
        repository.save(convertToEntity(dto));
    }
    
    public void update(CarroDTO dto) {
        repository.update(convertToEntity(dto));
    }
    
    public void delete(Long id) {
        repository.delete(id);
    }
    
    public List<CarroDTO> findAllBy(Fabricante fabricante){
        return convertToDTOs(repository.findAllBy(fabricante));
    }
    
    public List<CarroDTO> findAllBy(Modelo modelo){
        return convertToDTOs(repository.findAllBy(modelo));
    }
    
    private List<CarroDTO> convertToDTOs(List<Carro> carros) {
        List<CarroDTO> dtos = new ArrayList<>();
        for (Carro carro : carros) {
            dtos.add(convertToDTO(carro));
        }
        return dtos;
    }

    private CarroDTO convertToDTO(Carro entity) {
        CarroDTO dto = new CarroDTO();
        dto.setId(entity.getId());
        dto.setFabricanteId(entity.getFabricanteId());
        dto.setModeloId(entity.getModeloId());
        dto.setNome(repository.findNomeModeloById(entity.getModeloId()));
        dto.setFabricante(repository.findNomeFabricanteById(entity.getFabricanteId()));
        dto.setAno(entity.getAno());
        dto.setCor(entity.getCor());
        dto.setPlaca(entity.getPlaca());
        dto.setDisponivel(entity.getDisponivel());
        dto.setValorLocacao(entity.getValorlocacao());
        return dto;
    }

    private Carro convertToEntity(CarroDTO dto) {
        Carro entity = new Carro();
        entity.setId(dto.getId());
        entity.setFabricanteId(dto.getFabricanteId());
        entity.setModeloId(dto.getModeloId());
        entity.setAno(dto.getAno());
        entity.setCor(dto.getCor());
        entity.setPlaca(dto.getPlaca());
        entity.setDisponivel(dto.getDisponivel());
        entity.setValorlocacao(dto.getValorLocacao());
        return entity;
    }
}
