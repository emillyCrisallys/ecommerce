package br.grupointegrado.ecommerce.repository;

import br.grupointegrado.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}