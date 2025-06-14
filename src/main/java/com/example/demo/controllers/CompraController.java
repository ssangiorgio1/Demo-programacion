package com.example.demo.controllers;

import com.example.demo.dto.CompraDTO;
import com.example.demo.services.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public ResponseEntity<String> confirmarCompra(@RequestBody CompraDTO compraDTO) {
        try {
            compraService.realizarCompra(compraDTO);
            return ResponseEntity.ok("¡Compra realizada con éxito!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error al realizar la compra: " + e.getMessage());
        }
    }
}
