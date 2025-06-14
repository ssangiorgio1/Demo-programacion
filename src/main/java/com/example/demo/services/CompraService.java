package com.example.demo.services;

import com.example.demo.dto.CompraDTO;
import com.example.demo.entities.*;
import com.example.demo.repositories.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CompraService {

    private final ClienteRepository clienteRepository;
    private final FuncionRepository funcionRepository;
    private final EntradaRepository entradaRepository;
    private final VentaRepository ventaRepository;
    private final PeliculaRepository peliculaRepository;

    public CompraService(ClienteRepository clienteRepository,
                         FuncionRepository funcionRepository,
                         EntradaRepository entradaRepository,
                         VentaRepository ventaRepository, PeliculaRepository peliculaRepository) {
        this.clienteRepository = clienteRepository;
        this.funcionRepository = funcionRepository;
        this.entradaRepository = entradaRepository;
        this.ventaRepository = ventaRepository;
        this.peliculaRepository = peliculaRepository;
    }
    public void realizarCompra(CompraDTO dto) {
        // 1. Crear o guardar cliente
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setEmail(dto.getEmail());
        cliente = clienteRepository.save(cliente);

        // 2. Buscar función
        Funcion funcion = funcionRepository.findById(dto.getFuncionId())
                .orElseThrow(() -> new RuntimeException("Función no encontrada."));

        // 3. Buscar película asociada a la función (para obtener el cine)
        Long peliculaId = funcion.getPelicula().getId(); // funcion debe tener este campo
        Pelicula pelicula = peliculaRepository.findById(peliculaId)
                .orElseThrow(() -> new RuntimeException("Película no encontrada."));

        // 4. Buscar entrada según asiento y función
        Entrada entrada = entradaRepository.findByAsientoAndFuncionId(dto.getAsiento(), dto.getFuncionId())
                .orElseThrow(() -> new RuntimeException("Asiento no disponible o no existe."));

        // 5. Validar que la entrada no haya sido vendida aún
        if (ventaRepository.existsByEntradaId(entrada.getId())) {
            throw new RuntimeException("El asiento ya fue comprado.");
        }

        // 6. Crear la venta
        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setFuncion(funcion);
        venta.setCine(pelicula.getCine()); // asumiendo que Pelicula tiene un campo cine
        venta.setFecha(LocalDate.now());
        venta.setPrecio(entrada.getPrecio());
        venta.setEntradaId(entrada.getId());

        ventaRepository.save(venta);
    }
}



