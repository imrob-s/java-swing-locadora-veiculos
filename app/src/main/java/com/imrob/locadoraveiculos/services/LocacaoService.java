package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.repositories.LocacaoRepository;
import com.imrob.locadoraveiculos.entities.Locacao;
import com.imrob.locadoraveiculos.DTO.LocacaoDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LocacaoService {
    private final LocacaoRepository locacaoRepository;

    public LocacaoService(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    public List<LocacaoDTO> findAll() {
        List<Locacao> locacoes = locacaoRepository.findAll();
        return convertToDTOs(locacoes);
    }

    public LocacaoDTO findLocacaoById(Long id) {
        Locacao locacao = locacaoRepository.findBy(id);
        return convertToDTO(locacao);
    }

    public LocacaoDTO findByClientName(String name) {
        Locacao locacao = locacaoRepository.findByClientName(name);
        return convertToDTO(locacao);
    }

    public List<LocacaoDTO> findByEntreDatasLocacao(LocalDateTime dataInicio, LocalDateTime dataFinal) {
        List<Locacao> locacoes = locacaoRepository.findByEntreDatas(dataInicio, dataFinal);
        return convertToDTOs(locacoes);
    }

    public void saveLocacao(LocacaoDTO locacaoDTO) {
        Locacao locacao = convertToEntity(locacaoDTO);
        locacaoRepository.save(locacao);
    }

    public void deleteLocacao(Long id) {
        locacaoRepository.delete(id);
    }

    public void updateLocacao(LocacaoDTO locacaoDTO) {
        Locacao locacao = convertToEntity(locacaoDTO);
        locacaoRepository.update(locacao);
    }

    private LocacaoDTO convertToDTO(Locacao locacao) {
        LocacaoDTO dto = new LocacaoDTO();
        dto.setId(locacao.getId());
        dto.setSeguradoraId(locacao.getSeguradoraId());
        dto.setCarroId(locacao.getCarroId());
        dto.setClientId(locacao.getClientId());
        dto.setDataLocacao(locacao.getDatalocacao());
        dto.setDataDevolucao(locacao.getDatadevolucao());
        dto.setDataDevolvida(locacao.getDatadevolvida());
        dto.setValorDesconto(locacao.getValorDesconto());
        dto.setValor(locacao.getValor());
        dto.setValorTotal(locacao.getValorTotal());
        return dto;
    }

    private List<LocacaoDTO> convertToDTOs(List<Locacao> locacoes) {
        List<LocacaoDTO> dtos = new ArrayList<>();
        for (Locacao locacao : locacoes) {
            dtos.add(convertToDTO(locacao));
        }
        return dtos;
    }

    private Locacao convertToEntity(LocacaoDTO locacaoDTO) {
        Locacao locacao = new Locacao();
        locacao.setId(locacaoDTO.getId());
        locacao.setSeguradoraId(locacaoDTO.getSeguradoraId());
        locacao.setCarroId(locacaoDTO.getCarroId());
        locacao.setClientId(locacaoDTO.getClientId());
        locacao.setDatalocacao(locacaoDTO.getDataLocacao());
        locacao.setDatadevolucao(locacaoDTO.getDataDevolucao());
        locacao.setDatadevolvida(locacaoDTO.getDataDevolvida());
        locacao.setValorDesconto(locacaoDTO.getValorDesconto());
        locacao.setValor(locacaoDTO.getValor());
        locacao.setValorTotal(locacaoDTO.getValorTotal());
        return locacao;
    }
}

