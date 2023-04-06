package com.test.turnosrotativos.service.Impl;

import com.test.turnosrotativos.entities.Concepto;
import com.test.turnosrotativos.repository.IConceptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ConceptoService {


    private final IConceptoRepository conceptoRepository;


   @Autowired
    public ConceptoService(IConceptoRepository conceptoRepository){
       this.conceptoRepository = conceptoRepository;
   }

   public List<Concepto> buscarTodos(){
       return conceptoRepository.findAll();
    }
}
