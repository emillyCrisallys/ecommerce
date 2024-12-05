package br.grupointegrado.ecommerce.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private Double preco;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "produto")
    private List<ProdutoFornecedor> produtoFornecedores;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<ProdutoFornecedor> getProdutoFornecedores() {
        return produtoFornecedores;
    }

    public void setProdutoFornecedores(List<ProdutoFornecedor> produtoFornecedores) {
        this.produtoFornecedores = produtoFornecedores;
    }
}