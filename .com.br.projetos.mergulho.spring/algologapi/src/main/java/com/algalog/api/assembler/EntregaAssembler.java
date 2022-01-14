package com.algalog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import com.algalog.api.model.Entrega;
import com.algalog.api.modelo.EntregaModel;
import com.algalog.api.modelo.input.EntregaInput;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntregaAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public EntregaModel toModel(Entrega entrega) {
        return modelMapper.map(entrega, EntregaModel.class);
    }

    public List<EntregaModel> toCollectionMode(List<Entrega> entregas) {
        return entregas.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaInput entregaInput) {
        return modelMapper.map(entregaInput, Entrega.class);
    }
}
