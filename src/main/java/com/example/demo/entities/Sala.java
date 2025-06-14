package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numero;
    private int capacidad;

    @ManyToOne
    @JoinColumn(name = "cine_id", nullable = false)
    private Cine cine;

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }
}
