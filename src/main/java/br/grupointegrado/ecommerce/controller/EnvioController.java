package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.model.Envio;
import br.grupointegrado.ecommerce.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {
    @Autowired
    private EnvioService envioService;

    @GetMapping
    public List<Envio> findAll() {
        return envioService.findAll();
    }

    @PostMapping
    public Envio save(@RequestBody Envio envio) {
        return envioService.save(envio);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        envioService.delete(id);
    }
}