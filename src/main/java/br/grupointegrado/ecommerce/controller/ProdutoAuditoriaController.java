package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.model.ProdutoAuditoria;
import br.grupointegrado.ecommerce.service.ProdutoAuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos-auditoria")
public class ProdutoAuditoriaController {
    @Autowired
    private ProdutoAuditoriaService produtoAuditoriaService;

    @GetMapping
    public List<ProdutoAuditoria> findAll() {
        return produtoAuditoriaService.findAll();
    }

    @PostMapping
    public ProdutoAuditoria save(@RequestBody ProdutoAuditoria produtoAuditoria) {
        return produtoAuditoriaService.save(produtoAuditoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoAuditoriaService.delete(id);
    }
}