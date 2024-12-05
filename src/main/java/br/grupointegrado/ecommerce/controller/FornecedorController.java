package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.dto.FornecedorRequestDTO;
import br.grupointegrado.ecommerce.model.Fornecedor;
import br.grupointegrado.ecommerce.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> findAll() {
        List<Fornecedor> fornecedores = fornecedorRepository.findAll();
        return ResponseEntity.ok(fornecedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Integer id) {
        return fornecedorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fornecedor> create(@RequestBody FornecedorRequestDTO dto) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(dto.nome());

        Fornecedor savedFornecedor = fornecedorRepository.save(fornecedor);
        return ResponseEntity.status(201).body(savedFornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Integer id, @RequestBody FornecedorRequestDTO dto) {
        return fornecedorRepository.findById(id)
                .map(existingFornecedor -> {
                    existingFornecedor.setNome(dto.nome());
                    Fornecedor updatedFornecedor = fornecedorRepository.save(existingFornecedor);
                    return ResponseEntity.ok(updatedFornecedor);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return fornecedorRepository.findById(id)
                .map(existingFornecedor -> {
                    fornecedorRepository.delete(existingFornecedor);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}