package com.example.demo.repositories;

import com.example.demo.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    boolean existsByEntradaId(Long entradaId);

    List<Venta> findByEntradaIdIn(List<Long> entradaIds);

}
