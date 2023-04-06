package com.test.turnosrotativos.repository;

import com.test.turnosrotativos.entities.Concepto;
import com.test.turnosrotativos.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

public interface IConceptoRepository extends JpaRepository<Concepto, Integer> {
}
