package br.grupointegrado.ecommerce.repository;

import br.grupointegrado.ecommerce.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}