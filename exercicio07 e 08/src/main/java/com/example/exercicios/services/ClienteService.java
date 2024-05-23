package com.example.exercicios.services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.exercicios.models.Cliente;

@Service
public class ClienteService {
    private HashMap<String, Cliente> clientes = new HashMap<>();

    public ClienteService() {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("João");
        cliente1.setSaldo(1000.0);
        cliente1.setSenha("senha123");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria");
        cliente2.setSaldo(1500.0);
        cliente2.setSenha("senha456");

        clientes.put(cliente1.getNome(), cliente1);
        clientes.put(cliente2.getNome(), cliente2);
    }

    public List<Cliente> findAll() {
        return clientes.values().stream().collect(Collectors.toList());
    }

    public Optional<Cliente> findByName(String nome) {
        return Optional.ofNullable(clientes.get(nome));
    }

    public Cliente save(Cliente cliente) {
        clientes.put(cliente.getNome(), cliente);
        return cliente;
    }
}
