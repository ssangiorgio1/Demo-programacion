package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private Double precio; // antes era 'total'

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "funcion_id")
    private Funcion funcion;

    @Column(name = "entrada_id")
    private Long entradaId;

    @ManyToOne
    @JoinColumn(name = "cine_id")
    private Cine cine; // si usás el cine en la venta
}
