package com.finora.finora_backend.infra.config;

import com.finora.finora_backend.application.services.UsuarioService;
import com.finora.finora_backend.domain.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public UsuarioService gerenciarUsuarioUseCase(UsuarioRepository usuarioRepository) {
        return new UsuarioService(usuarioRepository);
    }
}
