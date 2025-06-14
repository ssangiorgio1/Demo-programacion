package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "entrada")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String asiento;

    private Double precio;

    @Column(name = "funcion_id")
    private Long funcionId;
}
