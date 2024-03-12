package com.demo.example.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.entity.Cliente;
import com.demo.example.entity.Habitacion;
import com.demo.example.entity.Reserva;
import com.demo.example.repository.ClienteRepository;
import com.demo.example.repository.HabitacionRepository;
import com.demo.example.repository.ReservaRepository;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Habitacion> getAvailableHabitaciones(java.util.Date fecha_inicio, java.util.Date fecha_fin) {
        List<Reserva> overlappingReservations = reservaRepository.findOverlappingReservations(fecha_inicio, fecha_fin);
        List<Habitacion> reservedHabitaciones = overlappingReservations.stream()
                .map(Reserva::getHabitacion)
                .collect(Collectors.toList());
        return habitacionRepository.findAll().stream()
                .filter(habitacion -> !reservedHabitaciones.contains(habitacion))
                .collect(Collectors.toList());
    }

    public void addReserva(Date fecha_inicio, Date fecha_fin, int habitacion_id, int cliente_id) {
        // Convertir habitacion_id y cliente_id a Long
        Long habitacionIdLong = Long.valueOf(habitacion_id);
        Long clienteIdLong = Long.valueOf(cliente_id);

        // Buscar la habitación y el cliente
        Habitacion habitacion = habitacionRepository.findById(habitacionIdLong)
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));
        Cliente cliente = clienteRepository.findById(clienteIdLong)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Crear la reserva
        Reserva reserva = new Reserva();
        reserva.setHabitacion(habitacion);
        reserva.setCliente(cliente);
        reserva.setFecha_inicio(new java.sql.Date(fecha_inicio.getTime()));
        reserva.setFecha_fin(new java.sql.Date(fecha_fin.getTime()));

        // Guardar la reserva
        reservaRepository.save(reserva);
    }

    public void deleteReserva(Date fecha_inicio, Date fecha_fin, int habitacion_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteReserva'");
    }

    public void updateReserva(Date fecha_inicio, Date fecha_fin, int habitacion_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateReserva'");
    }

    // Añade más métodos según sea necesario
}