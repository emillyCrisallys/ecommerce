package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.model.Fornecedor;
import br.grupointegrado.ecommerce.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> findAll() {
        return fornecedorService.findAll();
    }

    @PostMapping
    public Fornecedor save(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.save(fornecedor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        fornecedorService.delete(id);
    }
}