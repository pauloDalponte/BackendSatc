package com.example.exercicios.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

public class TransacaoDTO {

    @NotBlank(message = "O nome do pagador é obrigatório.")
    private String pagador;

    @NotBlank(message = "O nome do recebedor é obrigatório.")
    private String recebedor;

    @NotNull(message = "A quantidade é obrigatória.")
    @Min(value = 1, message = "A quantidade deve ser maior que 0.")
    private Double quantidade;

    // Getters e setters
    public String getPagador() {
        return pagador;
    }

    public void setPagador(String pagador) {
        this.pagador = pagador;
    }

    public String getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(String recebedor) {
        this.recebedor = recebedor;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
