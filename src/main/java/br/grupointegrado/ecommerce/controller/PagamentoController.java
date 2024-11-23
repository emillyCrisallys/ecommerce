package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.model.Pagamento;
import br.grupointegrado.ecommerce.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public List<Pagamento> getAll() {
        return pagamentoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> getById(@PathVariable Long id) {
        Pagamento pagamento = pagamentoService.findById(id);
        return pagamento != null ? ResponseEntity.ok(pagamento) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Pagamento create(@RequestBody Pagamento pagamento) {
        return pagamentoService.save(pagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> update(@PathVariable Long id, @RequestBody Pagamento pagamento) {
        Pagamento existingPagamento = pagamentoService.findById(id);
        if (existingPagamento != null) {
            pagamento.setId(id);
            return ResponseEntity.ok(pagamentoService.save(pagamento));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pagamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

