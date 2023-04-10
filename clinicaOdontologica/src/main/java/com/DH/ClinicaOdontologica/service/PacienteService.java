package com.DH.ClinicaOdontologica.service;
import com.DH.ClinicaOdontologica.repository.IPacienteRepository;
import com.DH.ClinicaOdontologica.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PacienteService {

    private com.DH.ClinicaOdontologica.repository.IPacienteRepository IPacienteRepository;

    @Autowired
    public PacienteService(IPacienteRepository IPacienteRepository) {
        this.IPacienteRepository = IPacienteRepository;
    }

    public Optional<Paciente> buscarPacientePorCorreo(String correo) {
        return IPacienteRepository.findByEmail(correo);
    }

    public Paciente guardarPaciente(Paciente paciente) {
        return IPacienteRepository.save(paciente);
    }

    public Optional<Paciente> buscarPaciente(Long id) {
        return IPacienteRepository.findById(id);
    }

    public void eliminarPaciente(Long id) {

        IPacienteRepository.deleteById(id);
    }

    public void actualizarPaciente(Paciente paciente) {
        IPacienteRepository.save(paciente);
    }

    public List<Paciente> buscarPacientes() {
        return IPacienteRepository.findAll();
    }
}

