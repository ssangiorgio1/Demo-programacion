package com.example.demo.controllers;

import com.example.demo.dto.VentaDTO;
import com.example.demo.entities.*;
import com.example.demo.repositories.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaRepository ventaRepository;
    private final EntradaRepository entradaRepository;
    private final FuncionRepository funcionRepository;
    private final PeliculaRepository peliculaRepository;
    private final ClienteRepository clienteRepository;

    public VentaController(VentaRepository ventaRepository,
                           EntradaRepository entradaRepository,
                           FuncionRepository funcionRepository,
                           PeliculaRepository peliculaRepository,
                           ClienteRepository clienteRepository) {
        this.ventaRepository = ventaRepository;
        this.entradaRepository = entradaRepository;
        this.funcionRepository = funcionRepository;
        this.peliculaRepository = peliculaRepository;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public ResponseEntity<List<VentaDTO>> obtenerVentas() {
        List<Venta> ventas = ventaRepository.findAll();
        List<VentaDTO> resumenList = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Venta venta : ventas) {
            // 1. Obtener entrada
            Optional<Entrada> entradaOpt = entradaRepository.findById((long) venta.getEntradaId());
            if (entradaOpt.isEmpty()) continue;

            Entrada entrada = entradaOpt.get();

            // 2. Obtener función
            Optional<Funcion> funcionOpt = funcionRepository.findById(entrada.getFuncionId());
            if (funcionOpt.isEmpty()) continue;

            Funcion funcion = funcionOpt.get();

            // 3. Obtener película
            Optional<Pelicula> peliculaOpt = peliculaRepository.findById(funcion.getPelicula().getId());
            if (peliculaOpt.isEmpty()) continue;

            Pelicula pelicula = peliculaOpt.get();

            // 4. Obtener cliente
            Optional<Cliente> clienteOpt = clienteRepository.findById(venta.getCliente().getId());
            if (clienteOpt.isEmpty()) continue;

            Cliente cliente = clienteOpt.get();

            // 5. Crear DTO
            VentaDTO dto = new VentaDTO(
                    cliente.getNombre(),
                    cliente.getEmail(),
                    pelicula.getCine().getNombre(),
                    pelicula.getTitulo(),
                    funcion.getHorario(),
                    entrada.getAsiento(),
                    entrada.getPrecio(),
                    venta.getFecha().format(formatter)
            );

            resumenList.add(dto);
        }

        return ResponseEntity.ok(resumenList);
    }
}
