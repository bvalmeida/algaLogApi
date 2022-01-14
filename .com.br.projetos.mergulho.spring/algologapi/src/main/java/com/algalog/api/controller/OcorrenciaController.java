package com.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.algalog.api.assembler.OcorrenciaAssembler;
import com.algalog.api.model.Entrega;
import com.algalog.api.model.Ocorrencia;
import com.algalog.api.modelo.OcorrenciaModel;
import com.algalog.api.modelo.input.OcorrenciaInput;
import com.algalog.api.service.BuscaEntregaService;
import com.algalog.api.service.RegistroOcorrenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private RegistroOcorrenciaService registroOcorrenciaService;

    @Autowired
    private OcorrenciaAssembler ocorrenciaAssembler;

    @Autowired
    private BuscaEntregaService buscaEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId,
            @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId,
                ocorrenciaInput.getDescricao());

        return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }

}
