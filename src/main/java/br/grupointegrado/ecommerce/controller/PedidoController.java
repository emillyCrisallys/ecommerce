package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.dto.PedidoRequestDTO;
import br.grupointegrado.ecommerce.model.Pedido;
import br.grupointegrado.ecommerce.model.Cliente;
import br.grupointegrado.ecommerce.repository.PedidoRepository;
import br.grupointegrado.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody PedidoRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDateTime.now()); // Define a data do pedido

        Pedido savedPedido = pedidoRepository.save(pedido);
        return ResponseEntity.status(201).body(savedPedido);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getById(@PathVariable Integer id) {
        return pedidoRepository.findById(id)
                .map(pedido -> ResponseEntity.ok(pedido))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Integer id, @RequestBody PedidoRequestDTO dto) {
        return pedidoRepository.findById(id)
                .map(existingPedido -> {
                    Cliente cliente = clienteRepository.findById(dto.clienteId())
                            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

                    existingPedido.setCliente(cliente);
                    existingPedido.setDataPedido(LocalDateTime.now());

                    Pedido updatedPedido = pedidoRepository.save(existingPedido);
                    return ResponseEntity.ok(updatedPedido);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return pedidoRepository.findById(id)
                .map(existingPedido -> {
                    pedidoRepository.delete(existingPedido);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}