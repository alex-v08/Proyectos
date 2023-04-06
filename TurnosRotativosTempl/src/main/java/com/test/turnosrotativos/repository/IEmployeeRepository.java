package com.test.turnosrotativos.repository;

import com.test.turnosrotativos.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{


    Optional<Object> findByDni(String dni);

    Optional<Object> findByEmail(String email);
}
