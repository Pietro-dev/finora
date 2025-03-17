package com.finora.finora_backend.dto.usuarioDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestUsuarioDTO(
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String email,

        @NotBlank
        String senha) {

}
