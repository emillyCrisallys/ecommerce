package br.grupointegrado.ecommerce.repository;

import br.grupointegrado.ecommerce.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Integer> {
    
}