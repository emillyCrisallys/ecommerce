package br.grupointegrado.ecommerce.repository;

import br.grupointegrado.ecommerce.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioRepository extends JpaRepository<Envio, Long> {
}