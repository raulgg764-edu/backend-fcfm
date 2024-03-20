package com.fcfm.backend.service;

import com.fcfm.backend.model.Alumno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService{
    List<Alumno> alumnoList = new ArrayList<>();


    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void createAlumno(Alumno newAlumno){
        alumnoList.add(newAlumno);

    }

    @Override
    public Alumno getAlumnoById(int id) {
        return alumnoList.get(id);
    }
}
