package com.DH.ClinicaOdontologica.repository;

import com.DH.ClinicaOdontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {
}
