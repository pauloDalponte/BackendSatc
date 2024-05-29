package com.example.exercicios.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exercicios.dto.ClienteDTO;
import com.example.exercicios.mappers.ClienteMapper;
import com.example.exercicios.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
@Autowired
    private ClienteService clienteService;

    private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;

    @GetMapping("/{nome}")
    public ResponseEntity<ClienteDTO> fundByName(@PathVariable String nome){
        Optional<ClienteDTO> cliente = clienteService.findByName(nome)
            .map(clienteMapper::toDto);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
