package br.grupointegrado.ecommerce.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "fornecedor")
    private List<ProdutoFornecedor> produtoFornecedores;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ProdutoFornecedor> getProdutoFornecedores() {
        return produtoFornecedores;
    }

    public void setProdutoFornecedores(List<ProdutoFornecedor> produtoFornecedores) {
        this.produtoFornecedores = produtoFornecedores;
    }


}