package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.DTO.CarroDTO;
import com.imrob.locadoraveiculos.entities.Carro;
import com.imrob.locadoraveiculos.repositories.CarroRepository;
import com.imrob.locadoraveiculos.repositories.FabricanteRepository;
import com.imrob.locadoraveiculos.repositories.ModeloRepository;
import java.util.ArrayList;
import java.util.List;

public class CarroService {

    private final CarroRepository repository;

    public CarroService() {
        this.repository = new CarroRepository();
    }

    public List<CarroDTO> findAll() {
        List<Carro> resultList = repository.findAll();
        return convertToDTOs(resultList);
    }
    
    public CarroDTO findById(Long id) {
        return convertToDTO(repository.findById(id));
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
        dto.setFabricanteId(entity.getFabricante_id());
        dto.setModeloId(entity.getModelo_id());
        dto.setModelo(new ModeloRepository().findById(entity.getModelo_id()).getNome());
        dto.setFabricante(new FabricanteRepository().findById(entity.getFabricante_id()).getNome());
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
        entity.setFabricante_id(dto.getFabricanteId());
        entity.setModelo_id(dto.getModeloId());
        entity.setAno(dto.getAno());
        entity.setCor(dto.getCor());
        entity.setPlaca(dto.getPlaca());
        entity.setDisponivel(dto.getDisponivel());
        entity.setValorlocacao(dto.getValorLocacao());
        return entity;
    }
}
