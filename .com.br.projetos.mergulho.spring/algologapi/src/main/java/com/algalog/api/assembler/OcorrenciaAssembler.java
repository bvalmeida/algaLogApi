package com.algalog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import com.algalog.api.model.Ocorrencia;
import com.algalog.api.modelo.OcorrenciaModel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OcorrenciaAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public OcorrenciaModel toModel(Ocorrencia ocorrencia) {
        return modelMapper.map(ocorrencia, OcorrenciaModel.class);
    }

    public List<OcorrenciaModel> toCollectionModel(List<Ocorrencia> ocorrencias) {
        return ocorrencias.stream().map(this::toModel).collect(Collectors.toList());
    }
}
