package br.grupointegrado.ecommerce.repository;

import br.grupointegrado.ecommerce.model.ProdutoAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoAuditoriaRepository extends JpaRepository<ProdutoAuditoria, Integer> {
}