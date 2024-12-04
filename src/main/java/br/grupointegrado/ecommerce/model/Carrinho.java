package br.grupointegrado.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carrinho")
@IdClass(CarrinhoPK.class)
public class Carrinho {

    @Id
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Id
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Integer quantidade;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}