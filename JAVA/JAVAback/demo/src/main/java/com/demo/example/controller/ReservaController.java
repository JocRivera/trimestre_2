package com.demo.example.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.example.entity.Habitacion;
import com.demo.example.entity.ReservaForm;
import com.demo.example.service.ReservaService;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @Controller
    public class MainController {

        @GetMapping("/")
        public String home(Model model) {
            // Obtén la fecha actual
            Date startDate = new Date();

            // Crea una instancia de Calendar y establece la fecha al día siguiente
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.DATE, 1);
            Date endDate = calendar.getTime();

            // Obtén las habitaciones disponibles para las fechas dadas
            List<Habitacion> habitaciones = reservaService.getAvailableHabitaciones(startDate, endDate);

            // Añade las habitaciones al modelo
            model.addAttribute("habitaciones", habitaciones);

            // Devuelve la vista
            return "disponibles";
        }
    }

    @GetMapping("/consulta")
    public String mostrarFormulario(Model model) {
        model.addAttribute("reservaForm", new ReservaForm());
        return "consulta";
    }

    @GetMapping("/disponibles")
    public String getAvailableHabitaciones(
            Model model,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_inicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_fin) {
        List<Habitacion> habitaciones = reservaService.getAvailableHabitaciones(fecha_inicio, fecha_fin);
        model.addAttribute("habitaciones", habitaciones);
        return "disponibilidad"; // reemplaza "nombreDeTuVista" con el nombre de tu archivo HTML
    }

    // crear metodo para agregar reservas
    @GetMapping("/agregar")
    public String showAddReservaForm(Model model) {
        model.addAttribute("reservaForm", new ReservaForm());
        return "agregar"; // Devuelve el nombre de la vista del formulario
    }

    @PostMapping("/agregar")
    public String addReserva(@ModelAttribute ReservaForm reservaForm) {
        reservaService.addReserva(reservaForm.getFecha_inicio(), reservaForm.getFecha_fin(),
                reservaForm.getHabitacion_id(), reservaForm.getCliente_id());
        return "redirect:/";
    }

    /*
     * @PostMapping("/agregar")
     * public String addReserva(
     * 
     * @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_inicio,
     * 
     * @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_fin,
     * 
     * @RequestParam int habitacion_id,
     * 
     * @RequestParam int cliente_id) {
     * reservaService.addReserva(fecha_inicio, fecha_fin, habitacion_id,
     * cliente_id);
     * return "redirect:/reservas/disponibles";
     * }
     * 
     * @GetMapping("/agregar")
     * public String showAddReservaForm(Model model) {
     * model.addAttribute("reserva", new Reserva());
     * return "agregar"; // Devuelve el nombre de la vista del formulario
     * }
     */
    // ELIMINAR RESERVA
    @PostMapping("/eliminar")
    public void deleteReserva(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_inicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_fin,
            @RequestParam int habitacion_id) {
        reservaService.deleteReserva(fecha_inicio, fecha_fin, habitacion_id);
    }

    // ACTUALIZAR RESERVA
    @PostMapping("/actualizar")
    public void updateReserva(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_inicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_fin,
            @RequestParam int habitacion_id) {
        reservaService.updateReserva(fecha_inicio, fecha_fin, habitacion_id);
    }
}
