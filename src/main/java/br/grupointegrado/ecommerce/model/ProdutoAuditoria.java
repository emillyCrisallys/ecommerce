package br.grupointegrado.ecommerce.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "produto_auditoria")
public class ProdutoAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "valor_antigo")
    private Double valorAntigo;

    @Column(name = "valor_novo")
    private Double valorNovo;

    @Column(name = "data_alteracao")
    private LocalDateTime dataAlteracao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getValorAntigo() {
        return valorAntigo;
    }

    public void setValorAntigo(Double valorAntigo) {
        this.valorAntigo = valorAntigo;
    }

    public Double getValorNovo() {
        return valorNovo;
    }

    public void setValorNovo(Double valorNovo) {
        this.valorNovo = valorNovo;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}