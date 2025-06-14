package com.example.demo.entities;

import jakarta.persistence.Entity;

@Entity
public class SalaVIP extends Sala {

    private String beneficios;

    // Getters y Setters

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }
}
