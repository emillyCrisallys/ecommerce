package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.dto.CarrinhoRequestDTO;
import br.grupointegrado.ecommerce.model.Carrinho;
import br.grupointegrado.ecommerce.model.CarrinhoPK;
import br.grupointegrado.ecommerce.model.Cliente;
import br.grupointegrado.ecommerce.model.Produto;
import br.grupointegrado.ecommerce.repository.CarrinhoRepository;
import br.grupointegrado.ecommerce.repository.ClienteRepository;
import br.grupointegrado.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Carrinho>> findAll() {
        List<Carrinho> carrinhos = this.repository.findAll();
        return ResponseEntity.ok(carrinhos);
    }

    @GetMapping("/{clienteId}/{produtoId}")
    public ResponseEntity<Carrinho> findByIds(@PathVariable Integer clienteId, @PathVariable Integer produtoId) {
        CarrinhoPK pk = new CarrinhoPK(clienteId, produtoId);
        return this.repository.findById(pk)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{clienteId}/{produtoId}")
    public ResponseEntity<Carrinho> update(@PathVariable Integer clienteId, @PathVariable Integer produtoId, @RequestBody CarrinhoRequestDTO dto) {
        CarrinhoPK pk = new CarrinhoPK(clienteId, produtoId);
        return this.repository.findById(pk)
                .map(existingCarrinho -> {
                    existingCarrinho.setQuantidade(dto.quantidade());
                    this.repository.save(existingCarrinho);
                    return ResponseEntity.ok(existingCarrinho);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{clienteId}/{produtoId}")
    public ResponseEntity<Object> delete(@PathVariable Integer clienteId, @PathVariable Integer produtoId) {
        CarrinhoPK pk = new CarrinhoPK(clienteId, produtoId);
        return this.repository.findById(pk)
                .map(existingCarrinho -> {
                    this.repository.delete(existingCarrinho);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carrinho> save(@RequestBody CarrinhoRequestDTO dto) {
        Carrinho carrinho = new Carrinho();

        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Produto produto = produtoRepository.findById(dto.produtoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        carrinho.setCliente(cliente); // Alterado para usar a entidade Cliente
        carrinho.setProduto(produto); // Alterado para usar a entidade Produto
        carrinho.setQuantidade(dto.quantidade());

        this.repository.save(carrinho);
        return ResponseEntity.status(201).body(carrinho);
    }
}