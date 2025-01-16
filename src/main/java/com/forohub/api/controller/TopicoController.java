package com.forohub.api.controller;

import com.forohub.api.domain.topico.*;
import com.forohub.api.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public ResponseEntity<Page<DatosListarTopico>> listarTopicos(@RequestParam(required = false) String curso,
                                                                 @RequestParam(required = false) Integer anio,
                                                                 @PageableDefault(size = 10) Pageable paginacion){
        return ResponseEntity.ok(topicoService.listarTopicos(curso, anio, paginacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> datosTopico(@PathVariable Long id){
        return ResponseEntity.ok(topicoService.obtenerDatosTopico(id));
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(
            @RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {
        DatosRespuestaTopico datosRespuestaTopico = topicoService.registrarTopico(datosRegistroTopico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(datosRespuestaTopico.id()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(
            @RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        return ResponseEntity.ok(topicoService.actualizarTopico(datosActualizarTopico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}
