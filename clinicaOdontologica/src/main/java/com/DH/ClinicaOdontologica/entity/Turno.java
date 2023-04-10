package com.DH.ClinicaOdontologica.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "turnos")
@Setter @Getter
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private  Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "odontologo_id", referencedColumnName = "id")
    private  Odontologo odontologo;
    @Column
    private LocalDate fecha;

    public Turno(Long id, Paciente paciente, Odontologo odontologo, LocalDate fecha) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }
    public Turno(){

    }


}
