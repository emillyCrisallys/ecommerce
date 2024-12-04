package br.grupointegrado.ecommerce.repository;

import br.grupointegrado.ecommerce.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
}