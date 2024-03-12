package com.demo.example.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.entity.Habitacion;
import com.demo.example.repository.HabitacionRepository;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;

    @Autowired
    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    // Create
    public Habitacion createHabitacion(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    // Read
    public List<Habitacion> getAllHabitaciones() {
        return habitacionRepository.findAll();
    }

    public Optional<Habitacion> getHabitacionById(Long id) {
        return habitacionRepository.findById(id);
    }

    // Update
    public Habitacion updateHabitacion(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    // Delete
    public void deleteHabitacion(Long id) {
        habitacionRepository.deleteById(id);
    }

    public List<Habitacion> buscarHabitacionesDisponibles(LocalDate inicio, LocalDate fin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarHabitacionesDisponibles'");
    }
}
