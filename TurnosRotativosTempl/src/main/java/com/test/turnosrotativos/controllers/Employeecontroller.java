package com.test.turnosrotativos.controllers;


import com.test.turnosrotativos.entities.Employee;
import com.test.turnosrotativos.service.Impl.EmployeeService2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/empleados")
public class Employeecontroller {

    static Logger logger = LogManager.getLogger(Employeecontroller.class);

    @Autowired
    EmployeeService2 employeeService2;


    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
       

        return new ResponseEntity<Employee>((MultiValueMap<String, String>) employeeService2.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> buscarTodos(){
        logger.info("Se invoca al servicio de buscar todos los empleados");
        return ResponseEntity.ok(employeeService2.buscarTodos());
    }




}
