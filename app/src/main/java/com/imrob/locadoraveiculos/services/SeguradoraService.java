package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.DTO.EnderecoDTO;
import com.imrob.locadoraveiculos.repositories.SeguradoraRepository;
import com.imrob.locadoraveiculos.entities.Seguradora;
import com.imrob.locadoraveiculos.DTO.SeguradoraDTO;

import java.util.ArrayList;
import java.util.List;

public class SeguradoraService {
    private final SeguradoraRepository seguradoraRepository;
    private final EnderecoService enderecoService;

    public SeguradoraService() {
        this.seguradoraRepository = new SeguradoraRepository();
        this.enderecoService = new EnderecoService();
    }

    public List<SeguradoraDTO> findAll() {
        List<Seguradora> seguradoras = seguradoraRepository.findAll();
        return convertToDTOs(seguradoras);
    }

    public SeguradoraDTO findBy(Long id) {
        Seguradora seguradora = seguradoraRepository.findBy(id);
        return convertToDTO(seguradora);
    }

    public SeguradoraDTO findByName(String name) {
        Seguradora seguradora = seguradoraRepository.findByName(name);
        return convertToDTO(seguradora);
    }

    public void save(SeguradoraDTO seguradoraDTO, EnderecoDTO enderecoDTO) {
        Seguradora seguradora = convertToEntity(seguradoraDTO);
        Long enderecoId = enderecoService.save(enderecoDTO);
        seguradora.setEnderecoId(enderecoId);
        seguradoraRepository.save(seguradora);
    }

    public void delete(Long id) {
        seguradoraRepository.delete(id);
    }

    public void update(SeguradoraDTO seguradoraDTO) {
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
        return new SeguradoraDTO(
                seguradora.getId(),
                seguradora.getNome(),
                seguradora.getCnpj(),
                seguradora.getEmail(),
                seguradora.getValor(),
                seguradora.getEnderecoId(),
                seguradora.getTelefone()
                );
    }

    private Seguradora convertToEntity(SeguradoraDTO seguradoraDTO) {
        return new Seguradora(
                seguradoraDTO.getId(),
                seguradoraDTO.getNome(),
                seguradoraDTO.getCnpj(),
                seguradoraDTO.getEmail(),
                seguradoraDTO.getValor(),
                seguradoraDTO.getEnderecoId(),
                seguradoraDTO.getTelefone()
        );

    }
}
