package com.dh.integrador.controller;


import com.dh.integrador.model.PacienteDTO;
import com.dh.integrador.services.PacienteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteServiceImp pacienteService;
    @Autowired
    public PacienteController(PacienteServiceImp pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("")
    public ResponseEntity<?> guardarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.guardarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPaciente(@PathVariable("id") long id){
        return pacienteService.buscarPaciente(id);
    }

    @GetMapping("")
    public Collection<PacienteDTO> listarPacientes(){
        return pacienteService.buscarTodos();
    }

    @PutMapping("")
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.actualizarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable("id") long id){
        pacienteService.borrarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
