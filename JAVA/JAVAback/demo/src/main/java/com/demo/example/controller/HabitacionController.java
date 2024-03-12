package com.demo.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.entity.Habitacion;
import com.demo.example.service.HabitacionService;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionController {

    private final HabitacionService habitacionService;

    @Autowired
    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping
    public String getHabitacionesPage(Model model) {
        List<Habitacion> habitaciones = habitacionService.getAllHabitaciones();
        model.addAttribute("habitaciones", habitaciones);
        return "habitaciones";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        return "habitacionesCrear";
    }

    @PostMapping
    public String createHabitacion(@ModelAttribute Habitacion habitacion) {
        Habitacion createdHabitacion = habitacionService.createHabitacion(habitacion);
        return "redirect:/habitaciones";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> getHabitacionById(@PathVariable Long id) {
        Habitacion habitacion = habitacionService.getHabitacionById(id)
                .orElseThrow(() -> new RuntimeException("Habitacion no encontrada"));
        return new ResponseEntity<>(habitacion, HttpStatus.OK);
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Habitacion habitacion = habitacionService.getHabitacionById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid habitacion Id:" + id));
        model.addAttribute("habitacion", habitacion);
        return "habitacionActualizar";
    }

    @PostMapping("/update")
    public String updateHabitacion(@ModelAttribute Habitacion habitacion) {
        habitacionService.updateHabitacion(habitacion);
        return "redirect:/habitaciones";
    }

    @GetMapping("/delete")
    public String showDeleteForm() {
        return "habitacionBorrar";
    }

    @PostMapping("/delete")
    public String deleteHabitacion(@RequestParam("id") Long id) {
        habitacionService.deleteHabitacion(id);
        return "redirect:/habitaciones";
    }
}

