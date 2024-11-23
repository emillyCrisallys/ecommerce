package br.grupointegrado.ecommerce.service;

import br.grupointegrado.ecommerce.model.Carrinho;
import br.grupointegrado.ecommerce.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public List<Carrinho> findAll() {
        return carrinhoRepository.findAll();
    }

    public Carrinho findById(Long id) {
        return carrinhoRepository.findById(id).orElse(null);
    }

    public Carrinho save(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    public void delete(Long id) {
        carrinhoRepository.deleteById(id);
    }
}

