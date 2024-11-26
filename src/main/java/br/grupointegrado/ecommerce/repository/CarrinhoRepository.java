package br.grupointegrado.ecommerce.repository;

import br.grupointegrado.ecommerce.model.Carrinho;
import br.grupointegrado.ecommerce.model.CarrinhoId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarrinhoRepository extends JpaRepository<Carrinho, CarrinhoId> {
}