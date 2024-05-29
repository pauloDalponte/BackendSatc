package com.example.exercicios.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.exercicios.dto.TransacaoDTO;
import com.example.exercicios.models.Transacao;

@Mapper
public interface TransacaoMapper {
    TransacaoMapper INSTANCE = Mappers.getMapper(TransacaoMapper.class);

    Transacao ToEntity(TransacaoDTO transacaoDTO);
}
