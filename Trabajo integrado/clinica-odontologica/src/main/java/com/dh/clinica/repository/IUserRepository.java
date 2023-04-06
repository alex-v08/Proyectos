package com.dh.clinica.repository;

import com.dh.clinica.login.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<AppUser, Integer> {


    Optional<AppUser> findByEmail(String email);
}
