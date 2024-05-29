package com.fcfm.backend.service;


import com.fcfm.backend.model.Alumno;

public interface AlumnoValidatorService {
    public boolean isValidDate(String date);
    public boolean isAlumnoValid(Alumno alumno);
}
