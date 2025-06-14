package com.example.demo.repositories;

import com.example.demo.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
