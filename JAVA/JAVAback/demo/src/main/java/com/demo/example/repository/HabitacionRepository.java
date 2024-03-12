package com.demo.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.example.entity.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
}
