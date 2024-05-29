package com.example.exercicios.controllers;

import com.example.exercicios.dto.TransacaoDTO;
import com.example.exercicios.mappers.TransacaoMapper;
import com.example.exercicios.models.Cliente;
import com.example.exercicios.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    @Autowired
    private ClienteService clienteService;

    private final TransacaoMapper transacaoMapper = TransacaoMapper.INSTANCE;

    @PostMapping
    public ResponseEntity<TransacaoDTO> save(@Valid @RequestBody TransacaoDTO transacaoDTO) {
        Optional<Cliente> pagadorOpt = clienteService.findByName(transacaoDTO.getPagador());
        Optional<Cliente> recebedorOpt = clienteService.findByName(transacaoDTO.getRecebedor());

        if (pagadorOpt.isPresent() && recebedorOpt.isPresent()) {
            Cliente pagador = pagadorOpt.get();
            Cliente recebedor = recebedorOpt.get();

            if (pagador.getSaldo() >= transacaoDTO.getQuantidade()) {
                pagador.setSaldo(pagador.getSaldo() - transacaoDTO.getQuantidade());
                recebedor.setSaldo(recebedor.getSaldo() + transacaoDTO.getQuantidade());

                clienteService.save(pagador);
                clienteService.save(recebedor);

                return ResponseEntity.ok(transacaoDTO);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
