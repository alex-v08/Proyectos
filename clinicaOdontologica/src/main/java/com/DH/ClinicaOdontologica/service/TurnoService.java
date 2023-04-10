package com.DH.ClinicaOdontologica.service;
import com.DH.ClinicaOdontologica.repository.ITurnoRepository;
import com.DH.ClinicaOdontologica.dto.TurnoDTO;
import com.DH.ClinicaOdontologica.entity.Odontologo;
import com.DH.ClinicaOdontologica.entity.Paciente;
import com.DH.ClinicaOdontologica.entity.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

   private com.DH.ClinicaOdontologica.repository.ITurnoRepository ITurnoRepository;

   @Autowired
    public TurnoService(ITurnoRepository ITurnoRepository) {
        this.ITurnoRepository = ITurnoRepository;
    }

    public List<TurnoDTO> listarTurnos(){
       List<Turno> turnosEncontrados= ITurnoRepository.findAll();

        List<TurnoDTO> respuesta=new ArrayList<>();
        for (Turno turno:turnosEncontrados) {
            respuesta.add(turnoAturnoDTO(turno));
                    }
        return respuesta;
    }
    public Optional<TurnoDTO> buscarTurno(Long id){
        Optional<Turno> turnoBuscado= ITurnoRepository.findById(id);
        if(turnoBuscado.isPresent()){

            return Optional.of(turnoAturnoDTO(turnoBuscado.get()));
        }
        else{

            return Optional.empty();
        }
    }
    public void eliminarTurno(Long id){
        ITurnoRepository.deleteById(id);
    }
    public void actualizarTurno(TurnoDTO turnodto){
        ITurnoRepository.save(turnoDTOaTurno(turnodto));
    }
    public TurnoDTO guardarTurno(TurnoDTO turnodto){
        Turno turnoGuardado= ITurnoRepository.save(turnoDTOaTurno(turnodto));
        return turnoAturnoDTO (turnoGuardado);
    }
    private TurnoDTO turnoAturnoDTO(Turno turno){

        TurnoDTO respuesta= new TurnoDTO();

        respuesta.setId(turno.getId());
        respuesta.setPacienteId(turno.getPaciente().getId());
        respuesta.setOdontologoId(turno.getOdontologo().getId());
        respuesta.setFecha(turno.getFecha());

        return respuesta;
    }
    private Turno turnoDTOaTurno(TurnoDTO turnodto){

        Turno respuesta= new Turno();
        Odontologo odontologo= new Odontologo();
        Paciente paciente= new Paciente();

        odontologo.setId(turnodto.getOdontologoId());
        paciente.setId(turnodto.getPacienteId());
        respuesta.setFecha(turnodto.getFecha());
        respuesta.setId(turnodto.getId());
        respuesta.setOdontologo(odontologo);
        respuesta.setPaciente(paciente);

        return respuesta;
    }


}
