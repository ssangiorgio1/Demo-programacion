package com.example.demo.controllers;

import com.example.demo.entities.Sala;
import com.example.demo.repositories.SalaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    private final SalaRepository salaRepository;

    public SalaController(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Sala>> obtenerTodasLasSalas() {
        List<Sala> salas = salaRepository.findAll();
        return ResponseEntity.ok(salas);
    }

    @PostMapping
    public ResponseEntity<Sala> crearSala(@RequestBody Sala sala) {
        Sala salaGuardada = salaRepository.save(sala);
        return ResponseEntity.ok(salaGuardada);
    }
}
