package com.finora.finora_backend.application.services;

import com.finora.finora_backend.application.dto.usuarioDTO.RequestAtualizarUsuarioDTO;
import com.finora.finora_backend.application.dto.usuarioDTO.RequestCriarUsuarioDTO;
import com.finora.finora_backend.application.dto.usuarioDTO.ResponseUsuarioDTO;
import com.finora.finora_backend.domain.models.Usuario;
import com.finora.finora_backend.domain.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<ResponseUsuarioDTO> listarTodos(){
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios.stream()
                .map(usuario -> new ResponseUsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail()))
                .toList();
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

    public ResponseUsuarioDTO buscarPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("ID não corresponde a nenhum usuário cadastrado!"));

        return new ResponseUsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }

    public ResponseUsuarioDTO atualizar(RequestAtualizarUsuarioDTO data){
        Usuario usuario = usuarioRepository.findById(data.id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        usuario.setNome(data.nome());
        usuario.setEmail(data.email());
        usuario.setSenha(data.senha());

        return new ResponseUsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }

    public ResponseUsuarioDTO deletar(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        usuarioRepository.deleteById(id);
        return new ResponseUsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );

    }
}
