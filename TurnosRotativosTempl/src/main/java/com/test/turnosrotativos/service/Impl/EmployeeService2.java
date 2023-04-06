package com.test.turnosrotativos.service.Impl;

import com.test.turnosrotativos.entities.Employee;
import com.test.turnosrotativos.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService2 {

    private final IEmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService2(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity<String> createEmployee(Employee employeeDTO) {


        if (employeeDTO.getFechaNacimiento().isAfter(LocalDate.now().minusYears(18))) {
            return ResponseEntity.badRequest().body("La edad del empleado no puede ser menor a 18 años.");
        }

        if (employeeRepository.findByDni(employeeDTO.getDni()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe un empleado con el documento ingresado.");
        }

        if (employeeRepository.findByEmail(employeeDTO.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe un empleado con el email ingresado.");
        }

        if (employeeDTO.getFechaIngreso().isAfter(LocalDate.now())) {
            return ResponseEntity.badRequest().body("La fecha de ingreso no puede ser posterior al día de la fecha.");
        }

        if (employeeDTO.getFechaNacimiento().isAfter(LocalDate.now())) {
            return ResponseEntity.badRequest().body("La fecha de nacimiento no puede ser posterior al día de la fecha.");
        }

        if (!employeeDTO.getNombre().matches("^[a-zA-Z]+$")) {
            return ResponseEntity.badRequest().body("Solo se permiten letras en el campo 'nombre'.");
        }

        if (!employeeDTO.getApellido().matches("^[a-zA-Z]+$")) {
            return ResponseEntity.badRequest().body("Solo se permiten letras en el campo 'apellido'.");
        }

        Employee employee = new Employee(employeeDTO.getNombre(), employeeDTO.getApellido(),
                employeeDTO.getDni(), employeeDTO.getEmail(), employeeDTO.getFechaNacimiento(),
                employeeDTO.getFechaIngreso(), LocalDate.now());

        employeeRepository.save(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(employee.getId()).toUri();

        return ResponseEntity.created(location).body("Empleado creado con éxito.");
    }

    public List<Employee> buscarTodos() {
        return employeeRepository.findAll();
    }
}
