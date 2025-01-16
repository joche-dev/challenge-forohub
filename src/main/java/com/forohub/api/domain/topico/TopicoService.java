package com.forohub.api.domain.topico;

import com.forohub.api.domain.usuario.Usuario;
import com.forohub.api.domain.usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<DatosListarTopico> listarTopicos(String curso, Integer anio, Pageable paginacion) {
        return topicoRepository.findByCursoYAnio(curso, anio, paginacion).map(DatosListarTopico::new);
    }

    public DatosRespuestaTopico obtenerDatosTopico(Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El tópico con ID " + id + " no fue encontrado"));

        return new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(),
                topico.getAutor().getNombre(), topico.getCurso(), topico.getStatus()
        );
    }

    public DatosRespuestaTopico registrarTopico(DatosRegistroTopico datosRegistroTopico) {
        var usuarioAutenticado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario autor = usuarioRepository.findById(usuarioAutenticado.getId())
                .orElseThrow(() -> new EntityNotFoundException("El usuario autenticado no fue encontrado"));

        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico, autor));

        return new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(),
                topico.getAutor().getNombre(), topico.getCurso(), topico.getStatus()
        );
    }

    @Transactional
    public DatosRespuestaTopico actualizarTopico(DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.findById(datosActualizarTopico.id())
                .orElseThrow(() -> new EntityNotFoundException("El tópico con ID " + datosActualizarTopico.id() + " no fue encontrado"));

        topico.actualizarDatos(datosActualizarTopico);

        return new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(),
                topico.getAutor().getNombre(), topico.getCurso(), topico.getStatus()
        );
    }

    @Transactional
    public void eliminarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new EntityNotFoundException("El tópico con ID " + id + " no fue encontrado");
        }
        topicoRepository.deleteById(id);
    }
}
