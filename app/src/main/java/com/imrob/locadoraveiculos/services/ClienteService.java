package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.DTO.ClienteDTO;
import com.imrob.locadoraveiculos.DTO.EnderecoDTO;
import com.imrob.locadoraveiculos.entities.Cliente;
import com.imrob.locadoraveiculos.repositories.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private final ClienteRepository repository;
    private final EnderecoService enderecoService;

    public ClienteService() {
        this.repository = new ClienteRepository();
        this.enderecoService = new EnderecoService();
    }

    public List<ClienteDTO> findAll() {
        return convertToDTOs(repository.findAll());
    }

    public ClienteDTO findBy(Long id) {
        return convertToDTO(repository.findById(id));
    }

//    public ClienteDTO findByCPF(String cpf) {
//        return convertToDTO(repository.findByCPF(cpf));
//    }

//    public ClienteDTO findByName(String name) {
//        return convertToDTO(repository.findByName(name));
//    }

    public void save(ClienteDTO clienteDto, EnderecoDTO enderecoDto) {
        Cliente cliente = convertToEntity(clienteDto);
        Long enderecoId = enderecoService.save(enderecoDto);
        cliente.setEnderecoId(enderecoId);
        repository.save(cliente);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public void delete(ClienteDTO clienteDto) {
        Cliente cliente = convertToEntity(clienteDto);
        enderecoService.delete(cliente.getEnderecoId());
        repository.delete(cliente.getId());
    }

    public void update(ClienteDTO clienteDto) {
        Cliente cliente = convertToEntity(clienteDto);
        repository.update(cliente);
    }

    private List<ClienteDTO> convertToDTOs(List<Cliente> clientes) {
        List<ClienteDTO> dtos = new ArrayList<>();
        for (Cliente cliente : clientes) {
            dtos.add(convertToDTO(cliente));
        }
        return dtos;
    }
    private Cliente convertToEntity(ClienteDTO dto) {
        return new Cliente(
                dto.getId(),
                dto.getNome(),
                dto.getRg(),
                dto.getCpf(),
                dto.getCnh(),
                dto.getDataVencimentoCNH(),
                dto.getEmail(),
                dto.getTelefone(),
                dto.getEnderecoId()
                );
    }

    private ClienteDTO convertToDTO(Cliente entity) {
        return new ClienteDTO (
                entity.getId(),
                entity.getNome(),
                entity.getRg(),
                entity.getCpf(),
                entity.getCnh(),
                entity.getDataVencimentoCNH(),
                entity.getEmail(),
                entity.getTelefone(),
                entity.getEnderecoId()
                );
    }
}