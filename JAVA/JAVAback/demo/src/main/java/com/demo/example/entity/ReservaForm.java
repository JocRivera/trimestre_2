package com.demo.example.entity;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class ReservaForm {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_inicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_fin;

    private int habitacion_id;

    private int cliente_id;

    // getters y setters
    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getHabitacion_id() {
        return habitacion_id;
    }

    public void setHabitacion_id(int habitacion_id) {
        this.habitacion_id = habitacion_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }
}
