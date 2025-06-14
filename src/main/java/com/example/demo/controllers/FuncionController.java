package com.example.demo.controllers;

import com.example.demo.entities.Funcion;
import com.example.demo.repositories.FuncionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funciones")
public class FuncionController {

    private final FuncionRepository funcionRepository;

    public FuncionController(FuncionRepository funcionRepository) {
        this.funcionRepository = funcionRepository;
    }

    @GetMapping
    public ResponseEntity<List<Funcion>> obtenerFunciones(
            @RequestParam(required = false) Long cineId,
            @RequestParam(required = false) Long peliculaId) {

        if (cineId != null && peliculaId != null) {
            return ResponseEntity.ok(funcionRepository.findByPelicula_Cine_IdAndPelicula_Id(cineId, peliculaId));
        } else {
            return ResponseEntity.ok(funcionRepository.findAll());
        }
    }
}
