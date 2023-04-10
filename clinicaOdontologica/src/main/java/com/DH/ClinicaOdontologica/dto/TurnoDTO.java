package com.DH.ClinicaOdontologica.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
public class TurnoDTO {
    private Long id;
    private LocalDate fecha;
    private Long PacienteId;
    private Long OdontologoId;


}
