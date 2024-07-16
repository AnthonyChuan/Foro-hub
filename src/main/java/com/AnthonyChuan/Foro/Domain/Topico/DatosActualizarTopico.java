package com.AnthonyChuan.Foro.Domain.Topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha) {
}
