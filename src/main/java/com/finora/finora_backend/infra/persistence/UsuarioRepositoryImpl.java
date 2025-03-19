package com.finora.finora_backend.infra.persistence;

import com.finora.finora_backend.domain.models.Usuario;
import com.finora.finora_backend.domain.repository.UsuarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositoryImpl extends JpaRepository<Usuario, Long>, UsuarioRepository {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
}
