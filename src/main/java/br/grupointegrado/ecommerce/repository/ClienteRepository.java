package br.grupointegrado.ecommerce.repository;

import br.grupointegrado.ecommerce.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}