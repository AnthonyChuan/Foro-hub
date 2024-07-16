package com.AnthonyChuan.Foro.Domain.Topico;

import com.AnthonyChuan.Foro.Domain.Curso.Curso;
import jakarta.persistence.EnumType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;

public record DatosRegistroTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Curso curso

) {
}
