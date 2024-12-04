package br.grupointegrado.ecommerce.dto;

public record CarrinhoRequestDTO(
        Integer clienteId,
        Integer produtoId,
        Integer quantidade
) {}