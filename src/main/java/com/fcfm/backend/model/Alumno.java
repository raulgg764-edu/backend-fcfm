package com.fcfm.backend.model;

public class Alumno {

    //Atributos
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNac;
    private String telefono;
    private String email;

    //Getters Setters de Alumno
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public String getFechaNac() {return fechaNac;}
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
    public String getTelefono() { return telefono;}
    public void setTelefono(String telefono) { this.telefono = telefono;    }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email;     }

}
