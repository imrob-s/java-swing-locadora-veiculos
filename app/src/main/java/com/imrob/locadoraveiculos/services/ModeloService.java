package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.DTO.ModeloDTO;
import com.imrob.locadoraveiculos.entities.Fabricante;
import com.imrob.locadoraveiculos.entities.Modelo;
import com.imrob.locadoraveiculos.repositories.FabricanteRepository;
import com.imrob.locadoraveiculos.repositories.ModeloRepository;
import java.util.ArrayList;
import java.util.List;

public class ModeloService {
    private final ModeloRepository repository;
    private final FabricanteRepository fabricanteRepository;

    public ModeloService() {
        this.repository = new ModeloRepository();
        this.fabricanteRepository = new FabricanteRepository();
    }

    public List<ModeloDTO> findAll() {
        return convertToDTOs(repository.findAll());
    }
    
    public ModeloDTO findById(Long id) {
        return convertToDTO(repository.findBy(id));
    }
    
    public List<ModeloDTO> findByFabricanteId(Long id) {
        return convertToDTOs(repository.findByFabricanteId(id));
    }
    
    public Long save(ModeloDTO modelo) {
        return repository.save(convertToEntity(modelo));
    }
    
    public void update(ModeloDTO modelo) {
        repository.update(convertToEntity(modelo));
    }
    
    public void delete(Long id) {
        repository.delete(id);
    }
    
    public List<ModeloDTO> convertToDTOs(List<Modelo> modelos){
        List<ModeloDTO> dtos = new ArrayList<>();
        for (Modelo modelo : modelos) {
            dtos.add(convertToDTO(modelo));
        }
        return dtos;
    }
    
    public ModeloDTO convertToDTO(Modelo entity) {
        Fabricante fabricante = fabricanteRepository.findBy(entity.getFabricanteId());
        ModeloDTO dto = new ModeloDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setFabricanteId(entity.getFabricanteId());
        dto.setFabricante(fabricante.getNome());
        
        return dto;
    }
    
    public Modelo convertToEntity(ModeloDTO dto) {
        Modelo entity = new Modelo();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setFabricanteId(dto.getFabricanteId());
        
        return entity;
    }
}
