package com.forohub.api.domain.topico;

import java.time.LocalDateTime;

public record DatosListarTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        String autor,
        String curso,
        Boolean status
) {
    public DatosListarTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(),topico.getAutor().getNombre(), topico.getCurso(), topico.getStatus());
    }
}
