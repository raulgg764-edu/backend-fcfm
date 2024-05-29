package com.fcfm.backend.service;

import com.fcfm.backend.model.Alumno;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class AlumnoValidatorServiceImpl implements AlumnoValidatorService{


    @Override
    public boolean isValidDate(String date) {
        try {
            LocalDate dateParsed =  LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean isAlumnoValid(Alumno alumno) {
        boolean date = isValidDate(alumno.getFechaNac());

        if(date){
            return true;
        }else{
            return false;
        }


    }
}
