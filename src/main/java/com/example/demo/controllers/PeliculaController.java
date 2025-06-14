package com.example.demo.controllers;

import com.example.demo.entities.Pelicula;
import com.example.demo.repositories.PeliculaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaRepository peliculaRepository;

    public PeliculaController(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Pelicula>> obtenerPeliculas() {
        return ResponseEntity.ok(peliculaRepository.findAll());
    }
}
