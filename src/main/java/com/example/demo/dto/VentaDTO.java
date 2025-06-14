package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {
    private String clienteNombre;
    private String clienteEmail;
    private String cine;
    private String pelicula;
    private String horario;
    private String asiento;
    private Double precio;
    private String fechaCompra;
}

