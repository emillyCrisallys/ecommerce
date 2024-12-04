package br.grupointegrado.ecommerce.dto;

public record EnvioRequestDTO(
        Integer pedidoId,
        String enderecoEntrega,
        String statusEntrega
) {}