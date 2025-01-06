package com.forohub.api.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    @Query("""
        SELECT t FROM Topico t 
        WHERE (:curso IS NULL OR LOWER(t.curso) LIKE LOWER(CONCAT('%', :curso, '%')))
        AND (:anio IS NULL OR YEAR(t.fecha) = :anio)
        ORDER BY t.fecha ASC
        """)
    Page<Topico> findByCursoYAnio(String curso, Integer anio, Pageable paginacion);
}
