package com.AnthonyChuan.Foro.Domain.Topico;

import com.AnthonyChuan.Foro.Domain.Curso.Curso;
import lombok.Getter;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        @Getter
        Long id,
        String titulo,
        String mensaje,
        Curso curso,
        LocalDateTime fecha
) {

}
