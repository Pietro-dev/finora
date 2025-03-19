package com.finora.finora_backend.services;

import com.finora.finora_backend.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

//    public UsuarioResponseDTO createUsuario(CreateUsuarioDTO dto) {
//        Usuario usuario = new Usuario();
//        usuario.setNome(dto.getNome());
//        usuario.setEmail(dto.getEmail());
//        usuario.setSenha(dto.getSenha()); // Senha não é exposta na resposta
//
//        Usuario savedUsuario = usuarioRepository.save(usuario);
//        return new UsuarioResponseDTO(savedUsuario.getId(), savedUsuario.getNome(), savedUsuario.getEmail());
//    }

//    public Usuario updateUsuario(Long id, Usuario usuario){
//        Usuario existingUsuario = usuarioRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
//
//        existingUsuario.setNome(usuario.getNome());
//        existingUsuario.setEmail(usuario.getEmail());
//
//        return usuarioRepository.save(existingUsuario);
//    }
}
