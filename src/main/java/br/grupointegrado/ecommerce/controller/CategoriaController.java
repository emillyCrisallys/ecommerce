package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.dto.CategoriaRequestDTO;
import br.grupointegrado.ecommerce.model.Categoria;
import br.grupointegrado.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> categoria = this.repository.findAll();
        return ResponseEntity.ok(categoria);
    }

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Integer id){
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("A categoria não foi encontrada"));
    }

    @PostMapping
    public ResponseEntity <Categoria> save(@RequestBody CategoriaRequestDTO dto){
        if(dto.nome().isEmpty()){
            return ResponseEntity.status(428).build();

        }
        Categoria categoria = new Categoria();
        categoria.setNome(dto.nome());

        this.repository.save(categoria);
        return ResponseEntity.ok(categoria);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        Categoria categoria = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("A categoria não foi encontrada"));

        this.repository.delete(categoria);

        return ResponseEntity.noContent().build();

    }

}
