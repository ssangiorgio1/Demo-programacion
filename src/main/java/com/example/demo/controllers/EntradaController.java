package com.example.demo.controllers;

import com.example.demo.entities.Entrada;
import com.example.demo.repositories.EntradaRepository;
import com.example.demo.repositories.VentaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/entradas")
public class EntradaController {

    private final EntradaRepository entradaRepository;
    private final VentaRepository ventaRepository;

    public EntradaController(EntradaRepository entradaRepository, VentaRepository ventaRepository) {
        this.entradaRepository = entradaRepository;
        this.ventaRepository = ventaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Entrada>> obtenerDisponibles(@RequestParam Long funcionId) {
        List<Entrada> todas = entradaRepository.findByFuncionId(funcionId);

        // Filtrar solo las que no están asociadas a una venta
        List<Entrada> disponibles = todas.stream()
                .filter(e -> !ventaRepository.existsByEntradaId(e.getId()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(disponibles);
    }
}
