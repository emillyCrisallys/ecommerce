package br.grupointegrado.ecommerce.controller;


import br.grupointegrado.ecommerce.dto.EnvioRequestDTO;
import br.grupointegrado.ecommerce.model.Categoria;
import br.grupointegrado.ecommerce.model.Envio;
import br.grupointegrado.ecommerce.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    @Autowired
    private EnvioRepository envioRepository;

    @GetMapping
    public ResponseEntity<List<Envio>> findAll() {
        List<Envio> envios = envioRepository.findAll();
        return ResponseEntity.ok(envios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envio> findById(@PathVariable Integer id) {
        return envioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
       public ResponseEntity<Envio> create(@RequestBody EnvioRequestDTO dto) {
        Envio envio = new Envio();
        envio.setEnderecoEntrega(dto.enderecoEntrega());
        envio.setStatusEntrega(dto.statusEntrega());

        Envio savedEnvio = envioRepository.save(envio);
        return ResponseEntity.status(201).body(savedEnvio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Envio> update(@PathVariable Integer id, @RequestBody EnvioRequestDTO dto) {
        return envioRepository.findById(id)
                .map(existingEnvio -> {

                    existingEnvio.setEnderecoEntrega(dto.enderecoEntrega());
                    existingEnvio.setStatusEntrega(dto.statusEntrega());
                    Envio updatedEnvio = envioRepository.save(existingEnvio);
                    return ResponseEntity.ok(updatedEnvio);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return envioRepository.findById(id)
                .map(existingEnvio -> {
                    envioRepository.delete(existingEnvio);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}