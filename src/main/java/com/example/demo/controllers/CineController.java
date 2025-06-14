package com.example.demo.controllers;

import com.example.demo.entities.Cine;
import com.example.demo.repositories.CineRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cines")
public class CineController {

    private final CineRepository cineRepository;

    public CineController(CineRepository cineRepository) {
        this.cineRepository = cineRepository;
    }

    @GetMapping
    public ResponseEntity<List<Cine>> obtenerCines() {
        return ResponseEntity.ok(cineRepository.findAll());
    }
}
