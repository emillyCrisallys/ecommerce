package br.grupointegrado.ecommerce.model;

import jakarta.persistence.*;


@Entity
@IdClass(CarrinhoId.class)
public class Carrinho {
    @Id
    private Long clienteId;

    @Id
    private Long produtoId;

    private int quantidade;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}