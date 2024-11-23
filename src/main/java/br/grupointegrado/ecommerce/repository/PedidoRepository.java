package br.grupointegrado.ecommerce.repository;

import br.grupointegrado.ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {}

