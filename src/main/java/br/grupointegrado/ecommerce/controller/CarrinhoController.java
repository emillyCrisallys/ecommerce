package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.model.Carrinho;
import br.grupointegrado.ecommerce.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {
    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    public List<Carrinho> findAll() {
        return carrinhoService.findAll();
    }

    @PostMapping
    public Carrinho save(@RequestBody Carrinho carrinho) {
        return carrinhoService.save(carrinho);
    }

    @DeleteMapping("/{clienteId}/{produtoId}")
    public void delete(@PathVariable Long clienteId, @PathVariable Long produtoId) {
        carrinhoService.delete(clienteId, produtoId);
    }
}

