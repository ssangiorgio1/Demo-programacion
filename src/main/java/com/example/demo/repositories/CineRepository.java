package com.example.demo.repositories;

import com.example.demo.entities.Cine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CineRepository extends JpaRepository<Cine, Long> {
}
