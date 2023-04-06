package com.test.turnosrotativos.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "empleados")
@Getter @Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", length = 30, nullable = false)
    @NotBlank(message = "El nombre no puede ser vacio")
    private String nombre;

    @Column(name = "apellido")
    @NotBlank(message = "El apellido no puede ser vacio")

    private String apellido;
    @Column(name = "nro_documento")
    @NotBlank(message = "El nro de documento no puede ser vacio")
    private String dni;
    @Column(name = "email")
    @NotBlank(message = "El email no puede ser vacio")
    private String email;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    private Employee() {
    }
    public Employee(String nombre, String apellido, String dni, String email, LocalDate fechaNacimiento, LocalDate fechaIngreso, LocalDate fechaCreacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.fechaCreacion = fechaCreacion;
    }


    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    List<Employee> employees;*/


}
