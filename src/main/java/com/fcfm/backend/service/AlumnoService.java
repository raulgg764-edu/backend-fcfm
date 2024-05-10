package com.fcfm.backend.service;

import com.fcfm.backend.model.Alumno;

import java.util.List;

public interface AlumnoService {
    List<Alumno> getAlumnoList();

    void createAlumno(Alumno newAlumno);
    Alumno getAlumnoById(int id);

    void updateAlumno(int id,Alumno updatedAlumno);

    void deleteAlumno(int id);

}
