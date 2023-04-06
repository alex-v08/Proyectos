package com.test.turnosrotativos.service.Impl;


import com.test.turnosrotativos.entities.Employee;
import com.test.turnosrotativos.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final IEmployeeRepository empleadoRepository;


    public EmployeeService(IEmployeeRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }



    public List<Employee> buscarTodos(){
       return empleadoRepository.findAll();
    }




    public Employee saveEmployee(Employee employee) {
        return empleadoRepository.save(employee);
    }
}
