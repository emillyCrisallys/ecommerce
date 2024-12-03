package br.grupointegrado.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carrinho")
@IdClass(CarrinhoPK.class)
public class Carrinho {

    @Id
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Integer clienteId;

    @Id
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Integer produtoId;

    private Integer quantidade;

    @ManyToOne
    private Produto produto;

    // Getters e Setters
    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}

