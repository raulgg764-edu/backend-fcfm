package com.fcfm.backend.controller;

import com.fcfm.backend.model.Alumno;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RequestMapping("/alumno")
public interface AlumnoApiController {

    //Controller con los mappings para hacer peticiones

    @PostMapping("/")
    @PreAuthorize("isAuthenticated()")
    ResponseEntity<Alumno> createAlumno(@Valid @RequestBody Alumno alumnoNuevo, BindingResult result);

    @GetMapping("/")
    @PreAuthorize("isAuthenticated()")
    ResponseEntity<List<Alumno>> getAlumnoList();

    @GetMapping("/{idAlumno}")
    @PreAuthorize("isAuthenticated()")
    ResponseEntity<Alumno> getAlumnoById(@PathVariable int idAlumno);

    @PutMapping("/{idAlumno}")
    @PreAuthorize("isAuthenticated()")
    ResponseEntity<Alumno> updateAlumno(@PathVariable int idAlumno, @Valid @RequestBody Alumno updatedAlumno, BindingResult result);

    @DeleteMapping("/{idAlumno}")
    @PreAuthorize("isAuthenticated()")
    ResponseEntity<String> deleteAlumno(@PathVariable int idAlumno);
}
