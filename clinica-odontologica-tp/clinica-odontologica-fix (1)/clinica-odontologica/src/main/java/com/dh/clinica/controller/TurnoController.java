package com.dh.clinica.controller;



import com.dh.clinica.dto.TurnoDTO;
import com.dh.clinica.service.OdontologoService;
import com.dh.clinica.service.PacienteService;
import com.dh.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService turnoService;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;

    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }
    //quiero listar todos

    @GetMapping
    public ResponseEntity<List<TurnoDTO>> buscarTurnos(){
        //ahora mandamos todo dentro de response
        return ResponseEntity.ok(turnoService.listarTurnos());
    }
    @PostMapping
    public ResponseEntity<TurnoDTO> registrarTurno(@RequestBody TurnoDTO turnodto){
        //si el odontologo o pacientes no exiten, tire un error.
        //de alguna manera tenemos que preguntar esto.
        //OdontologoService odontologoService= new OdontologoService();
        //PacienteService pacienteService=new PacienteService();
        if (odontologoService.buscarOdontologo(Math.toIntExact(turnodto.getOdontologoId())).isPresent()) {
            if (pacienteService.buscarPaciente(turnodto.getPacienteId()).isPresent()) {
                return ResponseEntity.ok(turnoService.guardarTurno(turnodto));
            } else {
                //bad request 400
                return ResponseEntity.badRequest().build();
            }
        } else {
            //bad request 400
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarTurno(@PathVariable Long id){
        Optional<TurnoDTO> turnoBuscado= turnoService.buscarTurno(id);
        if(turnoBuscado.isPresent()){
            return ResponseEntity.ok(turnoBuscado.get());
        }
        else{
            return ResponseEntity.notFound().build(); //enviamos un error 404
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarTurno(@PathVariable Long id){
        Optional<TurnoDTO> turnoBuscado= turnoService.buscarTurno(id);
        if(turnoBuscado.isPresent()) {
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Se elimino el turno con id: " + id);
        }
        else{
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Se elimino el turno con id:"+id);
            return ResponseEntity.badRequest().body("No se encontro el turno con id:"+id);
        }
    }
    @PutMapping()
    public ResponseEntity<String> actualizarTurno(@RequestBody TurnoDTO turnodto) {
        //podemos encontrarlo con el id del turno
        //con el paciente o odontologo
        Optional<TurnoDTO> turnoBuscado = turnoService.buscar(turnodto.getId());
        if (turnoBuscado.isPresent()) {
            //el turno existe. lo que deberiamos hacer es verificar el resto
            //OdontologoService odontologoService = new OdontologoService();
            //PacienteService pacienteService = new PacienteService();
            if (odontologoService.buscarOdontologo(Math.toIntExact(turnodto.getOdontologoId())).isPresent()
                    && pacienteService.buscar(Math.toIntExact(turnodto.getPacienteId())).isPresent()) {
                turnoService.actualizarTurno(turnodto);
                return ResponseEntity.ok("Se actualizó el turno con id: " + turnodto.getId());

            } else {
                return ResponseEntity.badRequest().body("No se pudo actualizar el turno con id:" + turnodto.getId() + "ya que hay un error en el paciente u odontologo");

            }
        } else {
            return ResponseEntity.badRequest().body("no encontramos el turno que usted quiere modificar" + turnodto.getId());


        }
    }
}
