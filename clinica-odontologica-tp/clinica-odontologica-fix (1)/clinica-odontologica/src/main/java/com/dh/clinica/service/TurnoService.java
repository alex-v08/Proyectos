package com.dh.clinica.service;

import com.dh.clinica.entity.Turno;
import com.dh.clinica.exceptions.BadRequestException;
import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    private final ITurnoRepository ITurnoRepository;





    @Autowired
    public TurnoService(ITurnoRepository ITurnoRepository) {
        this.ITurnoRepository = ITurnoRepository;
    }

    public Turno registrarTurno(Turno turno) {

        if(turno.getPaciente() == null || turno.getOdontologo() == null) throw new BadRequestException("No se encontro el paciente o el odontologo"
          );

        return ITurnoRepository.save(turno);
    }

    public List<Turno> listar() {

        return ITurnoRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException {
        if(!buscar(id).isPresent()) throw new RuntimeException("No se encontro el turno");
        ITurnoRepository.deleteById(id);
    }

    public Turno actualizar(Turno turno) {
        return ITurnoRepository.save(turno);
    }

    public Optional<Turno> buscar(Long id) {
        return ITurnoRepository.findById(id);
    }

}
