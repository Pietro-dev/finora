package com.finora.finora_backend.application.usecases;

import com.finora.finora_backend.application.dto.usuarioDTO.RequestCriarUsuarioDTO;
import com.finora.finora_backend.application.dto.usuarioDTO.ResponseUsuarioDTO;
import com.finora.finora_backend.domain.models.Usuario;
import com.finora.finora_backend.domain.repository.UsuarioRepository;

public class GerenciarUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public GerenciarUsuarioUseCase(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseUsuarioDTO registrar(RequestCriarUsuarioDTO requestUsuarioDTO){
        // verificar se o usuario existe pelo email
        if(usuarioRepository.existsByEmail(requestUsuarioDTO.email())){
            throw new RuntimeException("E-mail já cadastrado!");
        }

        // criando a entidade Usuario
        Usuario usuario = new Usuario();
        usuario.setNome(requestUsuarioDTO.nome());
        usuario.setEmail(requestUsuarioDTO.email());
        usuario.setSenha(requestUsuarioDTO.senha());

        usuario = usuarioRepository.save(usuario);

        return new ResponseUsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}
