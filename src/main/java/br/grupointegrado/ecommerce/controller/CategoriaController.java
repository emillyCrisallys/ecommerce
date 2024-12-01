package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.dto.CategoriaRequestDTO;
import br.grupointegrado.ecommerce.model.Categoria;
import br.grupointegrado.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public List<Categoria> findAll(){
         return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Integer id){
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("A categoria não foi encontrada"));
    }

    @PostMapping
    public Categoria save(@RequestBody CategoriaRequestDTO dto){
        Categoria categoria = new Categoria();
        categoria.setNome(dto.nome());

        return this.repository.save(categoria);

    }

}
