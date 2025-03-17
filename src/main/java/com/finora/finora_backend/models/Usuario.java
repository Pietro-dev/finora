package com.finora.finora_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finora.finora_backend.dto.usuarioDTO.RequestUsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @JsonIgnore
    private String senha;

    public Usuario(RequestUsuarioDTO requestUsuario){
        this.nome = requestUsuario.nome();
        this.email = requestUsuario.email();
        this.senha = requestUsuario.senha();
    }
}
