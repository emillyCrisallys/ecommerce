package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.model.Carrinho;
import br.grupointegrado.ecommerce.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {
    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    public List<Carrinho> getAll() {
        return carrinhoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> getById(@PathVariable Long id) {
        Carrinho carrinho = carrinhoService.findById(id);
        return carrinho != null ? ResponseEntity.ok(carrinho) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Carrinho create(@RequestBody Carrinho carrinho) {
        return carrinhoService.save(carrinho);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrinho> update(@PathVariable Long id,
    @RequestBody Carrinho carrinho) {
        Carrinho existingCarrinho = carrinhoService.findById(id);
        if (existingCarrinho != null) {
            carrinho.setId(id);
            return ResponseEntity.ok(carrinhoService.save(carrinho));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carrinhoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}