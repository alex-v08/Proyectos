package com.dh.clinica.dto;

import java.time.LocalDate;

public class TurnoDTO {
    private Long id;
    private LocalDate fecha;
    private Long PacienteId;
    private Long OdontologoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getPacienteId() {
        return PacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        PacienteId = pacienteId;
    }

    public Long getOdontologoId() {
        return OdontologoId;
    }

    public void setOdontologoId(Long odontologoId) {
        OdontologoId = odontologoId;
    }
}
