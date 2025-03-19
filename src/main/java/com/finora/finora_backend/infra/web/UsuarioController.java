package com.finora.finora_backend.infra.web;

import com.finora.finora_backend.application.dto.usuarioDTO.RequestCriarUsuarioDTO;
import com.finora.finora_backend.application.dto.usuarioDTO.ResponseUsuarioDTO;
import com.finora.finora_backend.application.usecases.GerenciarUsuarioUseCase;
import com.finora.finora_backend.domain.models.Usuario;
import com.finora.finora_backend.domain.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final GerenciarUsuarioUseCase gerenciarUsuarioUseCase;

    public UsuarioController(GerenciarUsuarioUseCase gerenciarUsuarioUseCase){
        this.gerenciarUsuarioUseCase = gerenciarUsuarioUseCase;
    }

    @PostMapping
    public ResponseEntity<ResponseUsuarioDTO> registrar(@Valid @RequestBody RequestCriarUsuarioDTO request){
        ResponseUsuarioDTO novoUsuario = gerenciarUsuarioUseCase.registrar(request);
        return ResponseEntity.ok(novoUsuario);
    }
}
