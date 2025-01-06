package com.forohub.api.infra.errores;

import com.forohub.api.domain.ValidacionException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ManejadorDeErrores {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DatosErrorValidacion>>  tratarError400(MethodArgumentNotValidException e){
        List<DatosErrorValidacion> errores = e.getFieldErrors()
                .stream()
                .map(DatosErrorValidacion::new)
                .toList();
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String,String>> tratarError404(EntityNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                "error","Recurso no encontrado",
                "mensaje", e.getMessage()
        ));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> tratarErrorDuplicidad(DataIntegrityViolationException e){
        return ResponseEntity.badRequest().body(Map.of(
                "error", "Error de integridad de datos",
                "mensaje",  "No se puede registrar el tópico porque ya existe un registro con los mismos datos"
        ));
    }

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity<Map<String, String>> tratarErrorDeValidacion(ValidacionException e){
        return ResponseEntity.badRequest().body(Map.of(
                "error", "Error de validación",
                "mensaje",  e.getMessage()
        ));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> tratarErrorDeParametro(MethodArgumentTypeMismatchException e){
        return ResponseEntity.badRequest().body(Map.of(
                "error", "Error de parámetro",
                "mensaje",  "El parámetro debe ser númerico"
        ));
    }

    private record DatosErrorValidacion(String campo, String error){
        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
