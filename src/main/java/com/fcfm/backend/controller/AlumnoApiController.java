package com.fcfm.backend.controller;

import com.fcfm.backend.model.Alumno;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/alumno")
public interface AlumnoApiController {

    //Controller con los mappings para hacer peticiones

    @PostMapping("/")
    ResponseEntity<Alumno> createAlumno(@Valid @RequestBody Alumno alumnoNuevo, BindingResult result);

    @GetMapping("/")
    ResponseEntity<List<Alumno>> getAlumnoList();

    @GetMapping("/{idAlumno}")
    ResponseEntity<Alumno> getAlumnoById(@PathVariable int idAlumno);

    @PutMapping("/{idAlumno}")
    ResponseEntity<Alumno> updateAlumno(@PathVariable int idAlumno, @Valid @RequestBody Alumno updatedAlumno, BindingResult result);

    @DeleteMapping("/{idAlumno}")
    ResponseEntity<String> deleteAlumno(@PathVariable int idAlumno);
}
