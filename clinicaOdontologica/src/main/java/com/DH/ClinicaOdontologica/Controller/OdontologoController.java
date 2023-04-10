package com.DH.ClinicaOdontologica.Controller;

import com.DH.ClinicaOdontologica.entity.Odontologo;
import com.DH.ClinicaOdontologica.exception.ResourceNotFoundExeption;
import com.DH.ClinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private OdontologoService odontologoService;
    @Autowired

    public OdontologoController(OdontologoService odontologoService) {

        this.odontologoService = odontologoService;
    }
    @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }
    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologos(){
        return ResponseEntity.ok(odontologoService.buscarTodosLosOdontologos());
    }
    @GetMapping("{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Long id){
        Optional<Odontologo> odontologoBuscado= odontologoService.buscarOdontologo(id);
        if(odontologoBuscado.isPresent()){
            return ResponseEntity.ok(odontologoBuscado.get());
        }
        else{
           return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundExeption {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok("Se elimino al odontologo: "+id);
    }

    }
