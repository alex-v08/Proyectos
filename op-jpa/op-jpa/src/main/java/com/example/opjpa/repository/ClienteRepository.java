package com.example.opjpa.repository;

import com.example.opjpa.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Integer > {
}
