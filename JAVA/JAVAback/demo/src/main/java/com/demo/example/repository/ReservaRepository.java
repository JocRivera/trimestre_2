package com.demo.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.example.entity.Reserva;

import java.util.Date;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query("SELECT r FROM reservas r WHERE :fecha_inicio < r.fecha_fin AND r.fecha_inicio < :fecha_fin")
    List<Reserva> findOverlappingReservations(@Param("fecha_inicio") Date fecha_inicio,
            @Param("fecha_fin") Date fecha_fin);
}
