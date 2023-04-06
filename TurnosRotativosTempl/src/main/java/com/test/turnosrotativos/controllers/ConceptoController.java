package com.test.turnosrotativos.controllers;


import com.test.turnosrotativos.entities.Concepto;
import com.test.turnosrotativos.service.Impl.ConceptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/concepto")
public class ConceptoController {
    @Autowired
    private ConceptoService conceptoService;
    @GetMapping
    public ResponseEntity<List<Concepto>> buscarTodos(){

        return ResponseEntity.ok(conceptoService.buscarTodos());
    }


}
