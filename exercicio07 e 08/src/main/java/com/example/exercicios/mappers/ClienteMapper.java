package com.example.exercicios.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.exercicios.models.Cliente;

import com.example.exercicios.dto.ClienteDTO;

@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO toDto(Cliente cliente);
}
