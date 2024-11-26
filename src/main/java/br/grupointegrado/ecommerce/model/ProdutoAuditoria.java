package br.grupointegrado.ecommerce.model;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class ProdutoAuditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto _id")
    private Produto produto;

    private BigDecimal valorAntigo;
    private BigDecimal valorNovo;

    private LocalDateTime dataAlteracao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getValorAntigo() {
        return valorAntigo;
    }

    public void setValorAntigo(BigDecimal valorAntigo) {
        this.valorAntigo = valorAntigo;
    }

    public BigDecimal getValorNovo() {
        return valorNovo;
    }

    public void setValorNovo(BigDecimal valorNovo) {
        this.valorNovo = valorNovo;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}