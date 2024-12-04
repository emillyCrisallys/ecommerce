package br.grupointegrado.ecommerce.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CarrinhoPK implements Serializable {

    private Integer cliente;
    private Integer produto;

    public CarrinhoPK() {}

    public CarrinhoPK(Integer cliente, Integer produto) {
        this.cliente = cliente;
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarrinhoPK that = (CarrinhoPK) o;
        return Objects.equals(cliente, that.cliente) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, produto);
    }
}