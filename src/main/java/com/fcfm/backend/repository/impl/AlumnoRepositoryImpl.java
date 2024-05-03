package com.fcfm.backend.repository.impl;

import com.fcfm.backend.repository.AlumnoRepository;
import com.fcfm.backend.repository.entity.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlumnoRepositoryImpl implements AlumnoRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void insertar(Alumno alumno){
        em.persist(alumno);
    }


    @Override
    public Alumno getAlumnoById(Long id){
        return em.find(Alumno.class,id);
    }

    @Transactional
    public List<Alumno> getAlumnoList(){

        return em.createQuery("SELECT a from Alumno a",Alumno.class).getResultList();
    }

    @Transactional
    public void deleteAlumno(Long id){
        Alumno deleteAlumno = em.find(Alumno.class,id);
        if(deleteAlumno!=null){
            em.remove(deleteAlumno);
        }
    }

    @Transactional
    public void updateAlumno(Long id, Alumno updatedAlumno){
        updatedAlumno.setAlumnoID(id);
        em.merge(updatedAlumno);
    }

}
