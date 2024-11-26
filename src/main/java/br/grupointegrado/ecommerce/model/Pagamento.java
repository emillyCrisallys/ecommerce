package br.grupointegrado.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private String metodoPagamento;

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

    public @NotNull BigDecimal getValor() {
        return valor;
    }

    public void setValor(@NotNull BigDecimal valor) {
        this.valor = valor;
    }

    public @NotNull String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(@NotNull String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}