package com.algalog.api.service;

import com.algalog.api.exception.EntidadeNaoEncontradaException;
import com.algalog.api.model.Entrega;
import com.algalog.api.repository.EntregaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaEntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));

    }

}
