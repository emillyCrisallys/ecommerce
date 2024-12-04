package br.grupointegrado.ecommerce.dto;

public record PagamentoRequestDTO(
        Integer pedidoId,
        Long metodoPagamentoId,
        Double valor
) {
}