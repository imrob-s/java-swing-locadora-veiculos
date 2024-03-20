package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.entities.Municipio;
import com.imrob.locadoraveiculos.repositories.MunicipioRepository;
import com.imrob.locadoraveiculos.repositories.SeguradoraRepository;
import com.imrob.locadoraveiculos.entities.Seguradora;
import com.imrob.locadoraveiculos.DTO.SeguradoraDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeguradoraService {
    private final SeguradoraRepository seguradoraRepository;
    private final MunicipioRepository municipioRepository;


    public SeguradoraService(SeguradoraRepository seguradoraRepository, MunicipioRepository municipioRepository) {
        this.seguradoraRepository = seguradoraRepository;
        this.municipioRepository = municipioRepository;
    }

    public List<SeguradoraDTO> findAll() {
        List<Seguradora> seguradoras = seguradoraRepository.findAll();
        return seguradoras.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public SeguradoraDTO findSeguradoraById(Long id) {
        Seguradora seguradora = seguradoraRepository.findBy(id);
        return convertToDTO(seguradora);
    }

    public SeguradoraDTO findSeguradoraByName(String name) {
        Seguradora seguradora = seguradoraRepository.findByName(name);
        return convertToDTO(seguradora);
    }

    public void saveSeguradora(SeguradoraDTO seguradoraDTO) {
        Seguradora seguradora = convertToEntity(seguradoraDTO);
        seguradoraRepository.save(seguradora);
    }

    public void deleteSeguradora(Long id) {
        seguradoraRepository.delete(id);
    }

    public void updateSeguradora(SeguradoraDTO seguradoraDTO) {
        Seguradora seguradora = convertToEntity(seguradoraDTO);
        seguradoraRepository.update(seguradora);
    }

    private List<SeguradoraDTO> convertToDTOs(List<Seguradora> seguradoras) {
        List<SeguradoraDTO> dtos = new ArrayList<>();
        for (Seguradora seguradora : seguradoras) {
            dtos.add(convertToDTO(seguradora));
        }
        return dtos;
    }

    private SeguradoraDTO convertToDTO(Seguradora seguradora) {
        Municipio municipio = municipioRepository.findById(seguradora.getMunicipioId());
        SeguradoraDTO dto = new SeguradoraDTO();
        dto.setId(seguradora.getId());
        dto.setNome(seguradora.getNome());
        dto.setCnpj(seguradora.getCnpj());
        dto.setEmail(seguradora.getEmail());
        dto.setValor(seguradora.getValor());
        dto.setMunicipio(municipio.getNome());
        dto.setEstado(municipio.getEstadoNome());
        dto.setTelefone(seguradora.getTelefone());
        return dto;
    }

    private Seguradora convertToEntity(SeguradoraDTO seguradoraDTO) {
        Municipio municipio = municipioRepository.findByName(seguradoraDTO.getMunicipio(), seguradoraDTO.getEstado());
        Seguradora seguradora = new Seguradora();
        seguradora.setId(seguradoraDTO.getId());
        seguradora.setNome(seguradoraDTO.getNome());
        seguradora.setCnpj(seguradoraDTO.getCnpj());
        seguradora.setEmail(seguradoraDTO.getEmail());
        seguradora.setValor(seguradoraDTO.getValor());
        seguradora.setMunicipioId(municipio.getId());
        seguradora.setEstadoId(municipio.getEstadoId());
        seguradora.setTelefone(seguradoraDTO.getTelefone());
        return seguradora;
    }
}
