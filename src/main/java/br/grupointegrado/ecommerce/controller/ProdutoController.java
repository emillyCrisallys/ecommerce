package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.dto.CategoriaRequestDTO;
import br.grupointegrado.ecommerce.dto.PedidoRequestDTO;
import br.grupointegrado.ecommerce.dto.ProdutoRequestDTO;
import br.grupointegrado.ecommerce.model.Categoria;
import br.grupointegrado.ecommerce.model.Fornecedor;
import br.grupointegrado.ecommerce.model.Produto;
import br.grupointegrado.ecommerce.repository.CategoriaRepository;
import br.grupointegrado.ecommerce.repository.FornecedorRepository;
import br.grupointegrado.ecommerce.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}/nome-preco")
    public ResponseEntity<Produto> updateNomePreco(@PathVariable Integer id, @RequestBody ProdutoRequestDTO dto) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(dto.nome());
                    produto.setPreco(dto.preco());
                    Produto updatedProduto = produtoRepository.save(produto);
                    return ResponseEntity.ok(updatedProduto);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}/categoria-fornecedor")
    public ResponseEntity<Produto> updateCategoriaFornecedor(@PathVariable Integer id, @RequestBody ProdutoRequestDTO dto) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                            .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
                    Fornecedor fornecedor = fornecedorRepository.findById(dto.fornecedorId())
                            .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

                    produto.setCategoria(categoria);
                    produto.setFornecedor(fornecedor);
                    Produto updatedProduto = produtoRepository.save(produto);
                    return ResponseEntity.ok(updatedProduto);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());

        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        produto.setCategoria(categoria);

        Fornecedor fornecedor = fornecedorRepository.findById(dto.fornecedorId())
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
        produto.setFornecedor(fornecedor);

        Produto savedProduto = produtoRepository.save(produto);
        return ResponseEntity.status(201).body(savedProduto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Integer id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        produtoRepository.delete(produtoOptional.get());
        return ResponseEntity.noContent().build();
    }
}