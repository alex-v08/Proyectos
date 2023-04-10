package com.DH.ClinicaOdontologica.Controller;

import com.DH.ClinicaOdontologica.dto.TurnoDTO;
import com.DH.ClinicaOdontologica.service.OdontologoService;
import com.DH.ClinicaOdontologica.service.PacienteService;
import com.DH.ClinicaOdontologica.service.TurnoService;
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


    @GetMapping
    public ResponseEntity<List<TurnoDTO>> buscarTurnos(){

        return ResponseEntity.ok(turnoService.listarTurnos());
    }
    @PostMapping
    public ResponseEntity<TurnoDTO> registrarTurno(@RequestBody TurnoDTO turnodto){

        if(odontologoService.buscarOdontologo(turnodto.getOdontologoId()).isPresent()
                &&pacienteService.buscarPaciente(turnodto.getPacienteId()).isPresent()){
           return ResponseEntity.ok(turnoService.guardarTurno(turnodto));
        }
        else {

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
        return ResponseEntity.notFound().build();
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

            return ResponseEntity.badRequest().body("No se encontro el turno con id:"+id);
        }
   }
   @PutMapping()
    public ResponseEntity<String> actualizarTurno(@RequestBody TurnoDTO turnodto) {

       Optional<TurnoDTO> turnoBuscado = turnoService.buscarTurno(turnodto.getId());
       if (turnoBuscado.isPresent()) {

           if (odontologoService.buscarOdontologo(turnodto.getOdontologoId()).isPresent()
                   && pacienteService.buscarPaciente(turnodto.getPacienteId()).isPresent()) {
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
