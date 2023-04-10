package com.DH.ClinicaOdontologica.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
/*2*/
@Entity
@Table(name = "pacientes")
@Setter @Getter
public class Paciente {
    //atrtibutos de la clase


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column(name="NOMBRE",length = 50, nullable = false)
   private String nombre;
   @Column
   private String apellido;
   @Column(name="DNI",length = 8, nullable = false)
   private String dni;
   @Column
   private LocalDate fechaDeIngreso;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;
    @Column(name="EMAIL",length = 50, nullable = false,unique = true)
    private String email;

    public Paciente(String nombre, String apellido, String dni, LocalDate fechaDeIngreso, Domicilio domicilio, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaDeIngreso = fechaDeIngreso;
        this.domicilio = domicilio;
        this.email=email;
    }

    public Paciente(Long id, String nombre, String apellido, String dni, LocalDate fechaDeIngreso, Domicilio domicilio, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaDeIngreso = fechaDeIngreso;
        this.domicilio = domicilio;
        this.email=email;
    }
    public Paciente(){

    }

}
