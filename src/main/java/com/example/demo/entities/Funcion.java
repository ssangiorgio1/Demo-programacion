package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "funcion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String horario;

    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;


    @Column(name = "sala_id")
    private Integer salaId;


}
