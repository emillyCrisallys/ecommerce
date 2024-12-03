package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.dto.CarrinhoRequestDTO;
import br.grupointegrado.ecommerce.model.Carrinho;
import br.grupointegrado.ecommerce.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoRepository repository;

    @GetMapping
    public ResponseEntity<List<Carrinho>> findAll(){
        List<Carrinho> Carrinho = this.repository.findAll();
        return ResponseEntity.ok(Carrinho);
    }

    @GetMapping("/{clienteId}")
    public Carrinho findByclienteId(@PathVariable Integer clienteId){
        return this.repository.findByclienteId(clienteId)
                .orElseThrow(() ->
                        new IllegalArgumentException("A Carrinho não foi encontrada"));
    }

    @PostMapping
    public ResponseEntity <Carrinho> save(@RequestBody CarrinhoRequestDTO dto){
        if(dto.nome().isEmpty()){
            return ResponseEntity.status(428).build();

        }
        Carrinho Carrinho = new Carrinho();
        Carrinho.setNome(dto.nome());

        this.repository.save(Carrinho);
        return ResponseEntity.ok(Carrinho);

    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<VoclienteId> delete(@PathVariable Integer clienteId){
        Carrinho Carrinho = this.repository.findByclienteId(clienteId)
                .orElseThrow(() ->
                        new IllegalArgumentException("A Carrinho não foi encontrada"));

        this.repository.delete(Carrinho);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Carrinho> update(@PathVariable Integer clienteId, @RequestBody CarrinhoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Carrinho Carrinho = this.repository.findByclienteId(clienteId)
                .orElseThrow(() ->
                        new IllegalArgumentException("A Carrinho não foi encontrada"));

        Carrinho.setNome(dto.nome());

        this.repository.save(Carrinho);
        return ResponseEntity.ok(Carrinho);
    }

}
