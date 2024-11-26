package br.grupointegrado.ecommerce.model;

import java.io.Serializable;
import java.util.Objects;

public class CarrinhoId implements Serializable {
    private Long clienteId;
    private Long produtoId;

    public CarrinhoId() {
    }

    public CarrinhoId(Long clienteId, Long produtoId) {
        this.clienteId = clienteId;
        this.produtoId = produtoId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarrinhoId)) return false;
        CarrinhoId that = (CarrinhoId) o;
        return Objects.equals(clienteId, that.clienteId) &&
                Objects.equals(produtoId, that.produtoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteId, produtoId);
    }
}
