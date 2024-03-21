package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.DTO.FabricanteDTO;
import com.imrob.locadoraveiculos.entities.Fabricante;
import com.imrob.locadoraveiculos.repositories.FabricanteRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FabricanteService {
    private final FabricanteRepository repository;

    public FabricanteService() {
        this.repository = new FabricanteRepository();
    }

    public List<FabricanteDTO> findAll() {
        return convertToDTOs(repository.findAll());
    }
    
    public FabricanteDTO findById(Long id) {
        return convertToDTO(repository.findBy(id));
    }
    
    public void save(FabricanteDTO fabricante){
        repository.save(convertToEntity(fabricante));
    }
    
    public void update(FabricanteDTO fabricante) {
        repository.update(convertToEntity(fabricante));
    }
    
    public void delete(Long id) {
        repository.delete(id);
    }
    
    private List<FabricanteDTO> convertToDTOs(List<Fabricante> fabricantes) {
        List<FabricanteDTO> dtos = new ArrayList<>();
        for (Fabricante fabricante : fabricantes) {
            dtos.add(convertToDTO(fabricante));
        }
        return dtos;
    }
    
    private FabricanteDTO convertToDTO(Fabricante entity){
        FabricanteDTO dto = new FabricanteDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        
        return dto;
    }
    
    private Fabricante convertToEntity(FabricanteDTO dto) {
        Fabricante entity = new Fabricante();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        
        return entity;
    }
}
