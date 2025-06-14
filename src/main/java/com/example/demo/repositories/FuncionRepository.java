package com.example.demo.repositories;

import com.example.demo.entities.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Long> {
    List<Funcion> findByPelicula_Cine_IdAndPelicula_Id(Long cineId, Long peliculaId);
}
