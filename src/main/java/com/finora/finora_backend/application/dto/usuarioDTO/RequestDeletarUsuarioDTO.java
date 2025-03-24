package com.finora.finora_backend.application.dto.usuarioDTO;

import jakarta.validation.constraints.NotNull;

public record RequestDeletarUsuarioDTO(
        @NotNull
        Long id
) {

}
