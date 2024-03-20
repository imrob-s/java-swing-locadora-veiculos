package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.DTO.ClienteDTO;
import com.imrob.locadoraveiculos.entities.Cliente;
import com.imrob.locadoraveiculos.entities.Municipio;
import com.imrob.locadoraveiculos.repositories.ClienteRepository;
import com.imrob.locadoraveiculos.repositories.MunicipioRepository;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final MunicipioRepository municipioRepository;

    public ClienteService(ClienteRepository clienteRepository, MunicipioRepository municipioRepository) {
        this.clienteRepository = clienteRepository;
        this.municipioRepository = municipioRepository;
    }

    public List<ClienteDTO> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> dtos = new ArrayList<>();

        for (Cliente cliente : clientes) {
            ClienteDTO dto = new ClienteDTO();
            copyEntityToDto(cliente, dto);
            dtos.add(dto);
        }

        return dtos;
    }

    public ClienteDTO findById(Long id) {
        ClienteDTO dto = new ClienteDTO();
        Cliente cliente = clienteRepository.findBy(id);
        copyEntityToDto(cliente, dto);
        return dto;
    }

    public ClienteDTO findByCPF(String cpf) {
        ClienteDTO dto = new ClienteDTO();
        Cliente cliente = clienteRepository.findByCPF(cpf);
        copyEntityToDto(cliente, dto);
        return dto;
    }

    public ClienteDTO findByName(String name) {
        ClienteDTO dto = new ClienteDTO();
        Cliente cliente = clienteRepository.findByName(name);
        copyEntityToDto(cliente, dto);
        return dto;
    }

    public void save(ClienteDTO clienteDto) {
        Cliente cliente = new Cliente();
        copyDtoToEntity(clienteDto, cliente);
        clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.delete(id);
    }

    public void update(ClienteDTO clienteDto) {
        Cliente cliente = new Cliente();
        copyDtoToEntity(clienteDto, cliente);
        clienteRepository.update(cliente);
    }

    private void copyDtoToEntity(ClienteDTO dto, Cliente entity) {
        Municipio municipio = municipioRepository.findByName(dto.getMunicipio(), dto.getEstado());
        entity.setNome(dto.getNome());
        entity.setRg(dto.getRg());
        entity.setCpf(dto.getCpf());
        entity.setCnh(dto.getCnh());
        entity.setDataVencimentoCNH(dto.getDataVencimentoCNH());
        entity.setEmail(dto.getEmail());
        entity.setLogradouro(dto.getLogradouro());
        entity.setMunicipioId(municipio.getId());
        entity.setEstadoId(municipio.getEstadoId());
        entity.setTelefone(dto.getTelefone());
    }

    private void copyEntityToDto(Cliente entity, ClienteDTO dto) {
        Municipio municipio = municipioRepository.findById(entity.getMunicipioId());
        dto.setNome(entity.getNome());
        dto.setRg(entity.getRg());
        dto.setCpf(entity.getCpf());
        dto.setCnh(entity.getCnh());
        dto.setDataVencimentoCNH(entity.getDataVencimentoCNH());
        dto.setEmail(entity.getEmail());
        dto.setLogradouro(entity.getLogradouro());
        dto.setMunicipio(municipio.getNome());
        dto.setEstado(municipio.getEstadoNome());
        dto.setTelefone(entity.getTelefone());
    }
}