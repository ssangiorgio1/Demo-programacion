package com.example.demo.controllers;

import com.example.demo.entities.Cliente;
import com.example.demo.repositories.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteGuardado);
    }
}
