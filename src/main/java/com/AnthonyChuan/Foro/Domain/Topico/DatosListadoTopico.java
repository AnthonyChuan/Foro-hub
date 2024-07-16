package com.AnthonyChuan.Foro.Domain.Topico;

import com.AnthonyChuan.Foro.Domain.Curso.Curso;

import java.time.LocalDateTime;

public record DatosListadoTopico(Long id, String titulo, String mensaje, Curso curso, LocalDateTime fecha) {


    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getCurso(),topico.getFecha());
    }
}
