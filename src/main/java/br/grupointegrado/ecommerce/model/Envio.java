package br.grupointegrado.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @NotNull
    private String enderecoEntrega;

    @NotNull
    private String statusEntrega;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public @NotNull String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(@NotNull String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public @NotNull String getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(@NotNull String statusEntrega) {
        this.statusEntrega = statusEntrega;
    }
}