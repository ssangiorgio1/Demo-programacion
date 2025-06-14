package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraDTO {
    private String nombre;
    private String email;
    private Long funcionId;
    private String asiento;
}
