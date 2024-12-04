package br.grupointegrado.ecommerce.dto;

public record ProdutoAuditoriaRequestDTO(
        Integer produtoId,
        Double valorAntigo,
        Double valorNovo
) {}