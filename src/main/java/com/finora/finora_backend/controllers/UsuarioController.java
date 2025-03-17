package com.finora.finora_backend.controllers;

import com.finora.finora_backend.models.Usuario;
import com.finora.finora_backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        var allUsuarios = repository.findAll();
        return ResponseEntity.ok(allUsuarios);
    }
}
