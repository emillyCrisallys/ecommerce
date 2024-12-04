package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.dto.ProdutoRequestDTO;
import br.grupointegrado.ecommerce.model.Produto;
import br.grupointegrado.ecommerce.repository.ProdutoRepository;
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


    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = new Produto();
        produto.setNome(produtoRequestDTO.nome());
        produto.setPreco(produtoRequestDTO.preco());
        produto.setId(produtoRequestDTO.categoriaId());
        produto.setId(produtoRequestDTO.fornecedorId());

        produto = produtoRepository.save(produto);

        return ResponseEntity.status(201).body(produto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Integer id, @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Produto produto = produtoOptional.get();
        produto.setNome(produtoRequestDTO.nome());
        produto.setPreco(produtoRequestDTO.preco());
        produto.setId(produtoRequestDTO.categoriaId());
        produto.setId(produtoRequestDTO.fornecedorId());

        produto = produtoRepository.save(produto);

        return ResponseEntity.ok(produto);
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
