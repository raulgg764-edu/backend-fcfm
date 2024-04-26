package com.fcfm.backend.repository.impl;

import com.fcfm.backend.repository.AlumnoRepository;
import com.fcfm.backend.repository.entity.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

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
}
