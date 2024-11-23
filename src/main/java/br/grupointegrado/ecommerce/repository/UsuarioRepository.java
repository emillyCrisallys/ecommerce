package br.grupointegrado.ecommerce.repository;

import br.grupointegrado.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}