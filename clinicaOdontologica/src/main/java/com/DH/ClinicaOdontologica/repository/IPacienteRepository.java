package com.DH.ClinicaOdontologica.repository;

import com.DH.ClinicaOdontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPacienteRepository extends JpaRepository<Paciente,Long > {
    Optional<Paciente> findByEmail(String email);
}
