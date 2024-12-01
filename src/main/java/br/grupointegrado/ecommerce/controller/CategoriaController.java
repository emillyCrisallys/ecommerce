package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.model.Categoria;
import br.grupointegrado.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
