package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.dto.ClienteRequestDTO;
import br.grupointegrado.ecommerce.model.Cliente;
import br.grupointegrado.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> findAll() {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClienteRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(400).body(null);
        }

        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());

        Cliente savedCliente = clienteRepository.save(cliente);
        return ResponseEntity.status(201).body(savedCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody ClienteRequestDTO dto) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        Cliente cliente = clienteOptional.get();
        cliente.setNome(dto.nome());

        Cliente updatedCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        clienteRepository.delete(clienteOptional.get());
        return ResponseEntity.noContent().build();
    }
}
