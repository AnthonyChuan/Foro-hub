package com.AnthonyChuan.Foro.Controller;


import com.AnthonyChuan.Foro.Domain.Topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topico")
public class TopicoController {
    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder){
        Topico topico=repository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico=new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getCurso(),
                topico.getFecha());
        URI url= uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopico(@PageableDefault(size = 3) Pageable paginacion){
        return ResponseEntity.ok(repository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
    }
    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico=repository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getCurso(),
                topico.getFecha()));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico=repository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaTopico(@PathVariable Long id){
        Topico topico=repository.getReferenceById(id);
        var datosTopico= new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getCurso(),
                topico.getFecha());
        return ResponseEntity.ok(datosTopico);
    }


}
