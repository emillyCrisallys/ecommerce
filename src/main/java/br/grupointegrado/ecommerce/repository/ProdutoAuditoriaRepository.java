package br.grupointegrado.ecommerce.repository;

import br.grupointegrado.ecommerce.model.ProdutoAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoAuditoriaRepository extends JpaRepository<ProdutoAuditoria, Long> {
}