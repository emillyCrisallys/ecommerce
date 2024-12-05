package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.dto.ProdutoFornecedorRequestDTO;
import br.grupointegrado.ecommerce.model.ProdutoFornecedor;
import br.grupointegrado.ecommerce.model.Produto;
import br.grupointegrado.ecommerce.model.Fornecedor;
import br.grupointegrado.ecommerce.repository.ProdutoFornecedorRepository;
import br.grupointegrado.ecommerce.repository.ProdutoRepository;
import br.grupointegrado.ecommerce.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtoFornecedor")
public class ProdutoFornecedorController {

    @Autowired
    private ProdutoFornecedorRepository produtoFornecedorRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping
    public ResponseEntity<List<ProdutoFornecedor>> findAll() {
        List< ProdutoFornecedor> produtoFornecedores = produtoFornecedorRepository.findAll();
        return ResponseEntity.ok(produtoFornecedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoFornecedor> findById(@PathVariable Integer id) {
        return produtoFornecedorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProdutoFornecedor> create(@RequestBody ProdutoFornecedorRequestDTO dto) {
        Produto produto = produtoRepository.findById(dto.produtoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        Fornecedor fornecedor = fornecedorRepository.findById(dto.fornecedorId())
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor();
        produtoFornecedor.setProduto(produto);
        produtoFornecedor.setFornecedor(fornecedor);

        ProdutoFornecedor savedProdutoFornecedor = produtoFornecedorRepository.save(produtoFornecedor);
        return ResponseEntity.status(201).body(savedProdutoFornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoFornecedor> update(@PathVariable Integer id, @RequestBody ProdutoFornecedorRequestDTO dto) {
        return produtoFornecedorRepository.findById(id)
                .map(existingProdutoFornecedor -> {
                    Produto produto = produtoRepository.findById(dto.produtoId())
                            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
                    Fornecedor fornecedor = fornecedorRepository.findById(dto.fornecedorId())
                            .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

                    existingProdutoFornecedor.setProduto(produto);
                    existingProdutoFornecedor.setFornecedor(fornecedor);

                    ProdutoFornecedor updatedProdutoFornecedor = produtoFornecedorRepository.save(existingProdutoFornecedor);
                    return ResponseEntity.ok(updatedProdutoFornecedor);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return produtoFornecedorRepository.findById(id)
                .map(existingProdutoFornecedor -> {
                    produtoFornecedorRepository.delete(existingProdutoFornecedor);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}