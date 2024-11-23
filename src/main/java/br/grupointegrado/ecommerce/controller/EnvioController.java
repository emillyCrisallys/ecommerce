package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.model.Envio;
import br.grupointegrado.ecommerce.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {
    @Autowired
    private EnvioService envioService;

    @GetMapping
    public List<Envio> getAll() {
        return envioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envio> getById(@PathVariable Long id) {
        Envio envio = envioService.findById(id);
        return envio != null ? ResponseEntity.ok(envio) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Envio create(@RequestBody Envio envio) {
        return envioService.save(envio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Envio> update(@PathVariable Long id, @RequestBody Envio envio) {
        Envio existingEnvio = envioService.findById(id);
        if (existingEnvio != null) {
            envio.setId(id);
            return ResponseEntity.ok(envioService.save(envio));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        envioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
