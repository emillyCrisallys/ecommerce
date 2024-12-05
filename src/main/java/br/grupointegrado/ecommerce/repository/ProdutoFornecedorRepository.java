package br.grupointegrado.ecommerce.repository;

import br.grupointegrado.ecommerce.model.ProdutoFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoFornecedorRepository extends JpaRepository<ProdutoFornecedor, Integer> {
}