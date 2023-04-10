package com.DH.ClinicaOdontologica.entity;



import lombok.Getter;

import javax.persistence.*;


@Entity
@Getter
@Table(name="domicilios")
public class Domicilio {
    //atributos de la clase.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String calle;
    @Column
    private Integer numero;
    @Column
    private  String localidad;
    @Column
    private String provincia;

    public Domicilio(String calle, Integer numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio(Long id, String calle, Integer numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
public Domicilio(){

}

}
