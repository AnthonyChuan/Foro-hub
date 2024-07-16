package com.AnthonyChuan.Foro.Domain.Topico;

import com.AnthonyChuan.Foro.Domain.Curso.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private Boolean activo;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    @Column(name = "fecha_creacion")
    private LocalDateTime fecha;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.activo=true;
        this.titulo= datosRegistroTopico.titulo();
        this.mensaje=datosRegistroTopico.mensaje();
        this.curso=datosRegistroTopico.curso();
        this.fecha=LocalDateTime.now();
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo()!=null){
            this.titulo= datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje()!=null){
            this.mensaje= datosActualizarTopico.mensaje();
        }
    }

    public void desactivarTopico() {
        this.activo=false;
    }
}
