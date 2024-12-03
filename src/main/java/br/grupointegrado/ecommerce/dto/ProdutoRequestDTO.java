package br.grupointegrado.ecommerce.dto;

public record ProdutoRequestDTO(
        String nome,
        Double preco,
        Integer categoriaId,
        Integer fornecedorId
) {}
