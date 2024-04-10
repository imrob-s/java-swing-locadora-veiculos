package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.DTO.EnderecoDTO;
import com.imrob.locadoraveiculos.entities.Endereco;
import com.imrob.locadoraveiculos.repositories.deprecated.EnderecoRepository;

public class EnderecoService {
   private final EnderecoRepository repository;

   public EnderecoService() {
      this.repository = new EnderecoRepository();
   }

   public EnderecoDTO findBy(Long id) {
      Endereco endereco = repository.findBy(id);
      return convertEntityToDto(endereco);
   }

   public Long save(EnderecoDTO dto) {
      Endereco endereco = convertDtoToEntity(dto);
      return repository.save(endereco);
   }

   public void update(EnderecoDTO dto) {
      Endereco endereco = convertDtoToEntity(dto);
      repository.update(endereco);
   }

   public void delete(Long id) {
      repository.delete(id);
   }

   private Endereco convertDtoToEntity(EnderecoDTO dto) {
      return new Endereco(
              dto.getId(),
              dto.getRua(),
              dto.getNumero(),
              dto.getBairro(),
              dto.getCidade(),
              dto.getEstado(),
              dto.getCep());
   }

   private EnderecoDTO convertEntityToDto(Endereco entity) {
      return new EnderecoDTO(
              entity.getId(),
              entity.getRua(),
              entity.getNumero(),
              entity.getBairro(),
              entity.getCidade(),
              entity.getEstado(),
              entity.getCep());
   }


}
