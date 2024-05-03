package com.fcfm.backend.repository;

import com.fcfm.backend.repository.entity.Alumno;

import java.util.List;

public interface AlumnoRepository {
    void insertar(Alumno alumno);
    Alumno getAlumnoById(Long id);

    List<Alumno> getAlumnoList();
    void deleteAlumno(Long id);

    void updateAlumno(Long id, Alumno updatedAlumno);
}
