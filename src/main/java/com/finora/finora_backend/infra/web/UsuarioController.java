package com.finora.finora_backend.infra.web;

import com.finora.finora_backend.application.dto.usuarioDTO.RequestAtualizarUsuarioDTO;
import com.finora.finora_backend.application.dto.usuarioDTO.RequestCriarUsuarioDTO;
import com.finora.finora_backend.application.dto.usuarioDTO.ResponseUsuarioDTO;
import com.finora.finora_backend.application.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseUsuarioDTO>> listarTodos(){
        List<ResponseUsuarioDTO> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<ResponseUsuarioDTO> registrar(@Valid @RequestBody RequestCriarUsuarioDTO request){
        ResponseUsuarioDTO novoUsuario = usuarioService.registrar(request);
        return ResponseEntity.ok(novoUsuario);
    }

    @PutMapping
    public ResponseEntity<ResponseUsuarioDTO> atualizar(@Valid @RequestBody RequestAtualizarUsuarioDTO request){
        ResponseUsuarioDTO usuarioAtualizado = usuarioService.atualizar(request);
        return  ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseUsuarioDTO> deletar(@PathVariable Long id){
        ResponseUsuarioDTO usuarioDeletado = usuarioService.deletar(id);

        return ResponseEntity.ok(usuarioDeletado);
    }
}
