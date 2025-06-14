package com.example.demo.dto;

public class ClienteDTO {

    private String nombre;
    private String email;
    private Integer cineId;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCineId() {
        return cineId;
    }

    public void setCineId(Integer cineId) {
        this.cineId = cineId;
    }
}
