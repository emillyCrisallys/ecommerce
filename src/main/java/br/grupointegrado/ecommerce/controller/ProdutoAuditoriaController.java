package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.dto.ProdutoAuditoriaRequestDTO;
import br.grupointegrado.ecommerce.model.ProdutoAuditoria;
import br.grupointegrado.ecommerce.repository.ProdutoAuditoriaRepository;
import br.grupointegrado.ecommerce.model.Produto;
import br.grupointegrado.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/auditorias")
public class ProdutoAuditoriaController {

    @Autowired
    private ProdutoAuditoriaRepository produtoAuditoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<ProdutoAuditoria> create(@RequestBody ProdutoAuditoriaRequestDTO dto) {
        Produto produto = produtoRepository.findById(dto.produtoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        ProdutoAuditoria produtoAuditoria = new ProdutoAuditoria();
        produtoAuditoria.setProduto(produto);
        produtoAuditoria.setValorAntigo(dto.valorAntigo());
        produtoAuditoria.setValorNovo(dto.valorNovo());
        produtoAuditoria.setDataAlteracao(LocalDateTime.now());

        ProdutoAuditoria savedAuditoria = produtoAuditoriaRepository.save(produtoAuditoria);
        return ResponseEntity.status(201).body(savedAuditoria);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoAuditoria>> getAll() {
        List<ProdutoAuditoria> auditorias = produtoAuditoriaRepository.findAll();
        return ResponseEntity.ok(auditorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoAuditoria> getById(@PathVariable Integer id) {
        return produtoAuditoriaRepository.findById(id)
                .map(auditoria -> ResponseEntity.ok(auditoria))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoAuditoria> update(@PathVariable Integer id, @RequestBody ProdutoAuditoriaRequestDTO dto) {
        return produtoAuditoriaRepository.findById(id)
                .map(existingAuditoria -> {
                    Produto produto = produtoRepository.findById(dto.produtoId())
                            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

                    existingAuditoria.setProduto(produto);
                    existingAuditoria.setValorAntigo(dto.valorAntigo());
                    existingAuditoria.setValorNovo(dto.valorNovo());
                    existingAuditoria.setDataAlteracao(LocalDateTime.now());

                    ProdutoAuditoria updatedAuditoria = produtoAuditoriaRepository.save(existingAuditoria);
                    return ResponseEntity.ok(updatedAuditoria);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return produtoAuditoriaRepository.findById(id)
                .map(existingAuditoria -> {
                    produtoAuditoriaRepository.delete(existingAuditoria);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}