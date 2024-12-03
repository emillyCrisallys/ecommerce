package br.grupointegrado.ecommerce.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CarrinhoPK implements Serializable {

    private Integer clienteId;
    private Integer produtoId;


    public CarrinhoPK() {}

    public CarrinhoPK(Integer clienteId, Integer produtoId) {
        this.clienteId = clienteId;
        this.produtoId = produtoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarrinhoPK that = (CarrinhoPK) o;
        return Objects.equals(clienteId, that.clienteId) && Objects.equals(produtoId, that.produtoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteId, produtoId);
    }
}
