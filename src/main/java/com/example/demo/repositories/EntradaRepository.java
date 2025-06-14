package com.example.demo.repositories;

import com.example.demo.entities.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EntradaRepository extends JpaRepository<Entrada, Long> {
    Optional<Entrada> findByAsientoAndFuncionId(String asiento, Long funcionId);
    List<Entrada> findByFuncionId(Long funcionId);
}
