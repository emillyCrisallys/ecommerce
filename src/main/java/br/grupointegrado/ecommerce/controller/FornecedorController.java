package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.model.Fornecedor;
import br.grupointegrado.ecommerce.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> getAll() {
        return fornecedorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> getById(@PathVariable Long id) {
        Fornecedor fornecedor = fornecedorService.findById(id);
        return fornecedor != null ? ResponseEntity.ok(fornecedor) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Fornecedor create(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.save(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        Fornecedor existingFornecedor = fornecedorService.findById(id);
        if (existingFornecedor != null) {
            fornecedor.setId(id);
            return ResponseEntity.ok(fornecedorService.save(fornecedor));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fornecedorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
