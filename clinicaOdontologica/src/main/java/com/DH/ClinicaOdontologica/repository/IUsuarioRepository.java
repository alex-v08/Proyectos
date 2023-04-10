package com.DH.ClinicaOdontologica.repository;

import com.DH.ClinicaOdontologica.login.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String correo);
}
