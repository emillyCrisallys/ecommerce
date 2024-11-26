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
    public List<Pagamento> findAll() {
        return pagamentoService.findAll();
    }

    @PostMapping
    public Pagamento save(@RequestBody Pagamento pagamento) {
        return pagamentoService.save(pagamento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pagamentoService.delete(id);
    }
}