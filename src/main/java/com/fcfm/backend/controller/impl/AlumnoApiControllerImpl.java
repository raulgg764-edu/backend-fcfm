package com.fcfm.backend.controller.impl;

import com.fcfm.backend.controller.AlumnoApiController;
import com.fcfm.backend.model.Alumno;
import com.fcfm.backend.service.AlumnoService;
import com.fcfm.backend.service.AlumnoValidatorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AlumnoApiControllerImpl implements AlumnoApiController {


    private AlumnoService alumnoService;
    private AlumnoValidatorService alumnoValidatorService;

    @Autowired
    AlumnoApiControllerImpl(AlumnoService alumnoService, AlumnoValidatorService alumnoValidatorService){
        this.alumnoService = alumnoService;
        this.alumnoValidatorService = alumnoValidatorService;
    }

    @Override
    public ResponseEntity<Alumno> createAlumno(@Valid @RequestBody Alumno alumnoNuevo, BindingResult result) {

        boolean isAlumnoValid = alumnoValidatorService.isAlumnoValid(alumnoNuevo);

        if(result.hasErrors()||!isAlumnoValid){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }else{
            alumnoService.createAlumno(alumnoNuevo);
        }

        return ResponseEntity.ok().body(alumnoNuevo);
    }

    @Override
    public ResponseEntity<List<Alumno>> getAlumnoList() {
        return  ResponseEntity.ok().body(alumnoService.getAlumnoList());

    }

    @Override
    public ResponseEntity<Alumno> getAlumnoById(int idAlumno) {
        return ResponseEntity.ok().body(alumnoService.getAlumnoById(idAlumno));
    }

    @Override
    public ResponseEntity<Alumno> updateAlumno(int idAlumno, @Valid @RequestBody Alumno updatedAlumno, BindingResult result) {
        try {
            boolean isAlumnoValid = alumnoValidatorService.isAlumnoValid(updatedAlumno);

            if(result.hasErrors()||!isAlumnoValid){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }else{
                alumnoService.updateAlumno(idAlumno, updatedAlumno);
                return ResponseEntity.ok(updatedAlumno);
            }
        }
        catch (Exception e){
            if(e instanceof ResponseStatusException){
                throw e;
            }else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }
    }

    @Override
    public ResponseEntity<String> deleteAlumno(int idAlumno) {
        try {
            alumnoService.deleteAlumno(idAlumno);
            return ResponseEntity.ok("Alumno eliminado");
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
