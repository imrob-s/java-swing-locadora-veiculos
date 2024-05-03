package com.imrob.locadoraveiculos.services;

import com.imrob.locadoraveiculos.DTO.LocacaoDTO;
import com.imrob.locadoraveiculos.entities.Locacao;
import com.imrob.locadoraveiculos.repositories.LocacaoRepository;
import java.util.ArrayList;
import java.util.List;

public class LocacaoService {
    private final LocacaoRepository locacaoRepository;

    public LocacaoService() {
        this.locacaoRepository = new LocacaoRepository();
    }

    public List<LocacaoDTO> findAll() {
        List<Locacao> locacoes = locacaoRepository.findAll();
        return convertToDTOs(locacoes);
    }

    public LocacaoDTO findById(Long id) {
        Locacao locacao = locacaoRepository.findById(id);
        return convertToDTO(locacao);
    }

//    public LocacaoDTO findByClientName(String name) {
//        Locacao locacao = locacaoRepository.findByClientName(name);
//        return convertToDTO(locacao);
//    }

//    public List<LocacaoDTO> findByEntreDatasLocacao(LocalDateTime dataInicio, LocalDateTime dataFinal) {
//        List<Locacao> locacoes = locacaoRepository.findByEntreDatas(dataInicio, dataFinal);
//        return convertToDTOs(locacoes);
//    }

    public void save(LocacaoDTO locacaoDTO) {
        Locacao locacao = convertToEntity(locacaoDTO);
        Long idLocacao = locacaoRepository.save(locacao);
        Long idCarro = findById(idLocacao).getCarroId();
        
        if (idLocacao != null) {
            new CarroService().updateStatus(idCarro, false);
        }
    }

    public void delete(Long id) {
        LocacaoDTO locacao = findById(id);
        new CarroService().updateStatus(locacao.getCarroId(), true);
        locacaoRepository.delete(id);
        
    }

    public void update(LocacaoDTO locacaoDTO) {
        Locacao locacao = convertToEntity(locacaoDTO);
        locacaoRepository.update(locacao);
    }

    private LocacaoDTO convertToDTO(Locacao locacao) {
        LocacaoDTO dto = new LocacaoDTO();
        dto.setId(locacao.getId());
        dto.setSeguradoraId(locacao.getSeguradora_id());
        dto.setCarroId(locacao.getCarro_id());
        dto.setClientId(locacao.getCliente_id());
        dto.setDataLocacao(locacao.getDatalocacao());
        dto.setDataDevolucao(locacao.getDatadevolucao());
        dto.setDataDevolvida(locacao.getDatadevolvida());
        dto.setValorDesconto(locacao.getValordesconto());
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
        locacao.setSeguradora_id(locacaoDTO.getSeguradoraId());
        locacao.setCarro_id(locacaoDTO.getCarroId());
        locacao.setCliente_id(locacaoDTO.getClientId());
        locacao.setDatalocacao(locacaoDTO.getDataLocacao());
        locacao.setDatadevolucao(locacaoDTO.getDataDevolucao());
        locacao.setDatadevolvida(locacaoDTO.getDataDevolvida());
        locacao.setValordesconto(locacaoDTO.getValorDesconto());
        locacao.setValor(locacaoDTO.getValor());
        locacao.setValorTotal(locacaoDTO.getValorTotal());
        return locacao;
    }
}

