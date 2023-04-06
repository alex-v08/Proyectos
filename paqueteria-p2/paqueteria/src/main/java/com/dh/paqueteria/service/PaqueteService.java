package com.dh.paqueteria.service;

import com.dh.paqueteria.exceptions.BadRequestException;
import com.dh.paqueteria.model.Estado;
import com.dh.paqueteria.model.Paquete;
import com.dh.paqueteria.repository.IPaqueteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaqueteService {

    private IPaqueteRepository IPaqueteRepository;

    public PaqueteService(IPaqueteRepository IPaqueteRepository) {
        this.IPaqueteRepository = IPaqueteRepository;
    }

    public Paquete agregar(Paquete paquete) throws BadRequestException{
       if(IPaqueteRepository.findPaqueteByCodigo(paquete.getCodigo()) != null)
            throw new BadRequestException("Ya existe un paquete con el codigo :"+paquete.getCodigo());
        if(paquete.getDestino() == null)
            throw new BadRequestException("El paquete debe contener un destino");


        return IPaqueteRepository.save(paquete);

    }

    public List<Paquete> listar(){
        return IPaqueteRepository.findAll();
    }
    public List<Paquete> paquetesEnCamino(){
        return IPaqueteRepository.findAllByEstado(Estado.EN_CAMINO);
    }



}
