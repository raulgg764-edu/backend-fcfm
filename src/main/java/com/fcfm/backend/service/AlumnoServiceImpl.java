package com.fcfm.backend.service;

import com.fcfm.backend.model.Alumno;
import com.fcfm.backend.repository.AlumnoRepository;
import com.fcfm.backend.utils.AlumnoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService{

    private AlumnoRepository alumnoRepository;

    @Autowired
    AlumnoServiceImpl(AlumnoRepository alumnoRepository){
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> getAlumnoList() {
        List <Alumno> alumnoList = new ArrayList<>();
        for(com.fcfm.backend.repository.entity.Alumno alumnoItem: alumnoRepository.getAlumnoList()){
            alumnoList.add(AlumnoMapper.alumnoEntityToAlumnoModel(alumnoItem));
        }
        return alumnoList;
    }

    public void createAlumno(Alumno newAlumno){
        alumnoRepository.insertar(AlumnoMapper.alumnoModelToAlumnoEntity(newAlumno));
    }

    @Override
    public Alumno getAlumnoById(int id) {
        com.fcfm.backend.repository.entity.Alumno alumnoEntity = alumnoRepository.getAlumnoById((long) id);
        return AlumnoMapper.alumnoEntityToAlumnoModel(alumnoEntity);
    }

    public void updateAlumno(int id, Alumno updatedAlumno){
        if(getAlumnoById(id)!=null){
            alumnoRepository.updateAlumno((long)id,AlumnoMapper.alumnoModelToAlumnoEntity(updatedAlumno));
        }

    }

    public void deleteAlumno(int id){
        if(getAlumnoById(id)!=null) alumnoRepository.deleteAlumno((long)id);
    }
}
