package com.DH.ClinicaOdontologica.service;
import com.DH.ClinicaOdontologica.exception.ResourceNotFoundExeption;
import com.DH.ClinicaOdontologica.repository.IOdontologoRepository;
import com.DH.ClinicaOdontologica.entity.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    private IOdontologoRepository IOdontologoRepository;


    @Autowired
    public OdontologoService(IOdontologoRepository IOdontologoRepository) {
        this.IOdontologoRepository = IOdontologoRepository;
    }


    public Odontologo guardarOdontologo(Odontologo odontologo){
        return IOdontologoRepository.save(odontologo);
    }
    public Optional<Odontologo> buscarOdontologo(Long id){
        return IOdontologoRepository.findById(id);
    }
    public void actualizarOdontologo(Odontologo odontologo){
        IOdontologoRepository.save(odontologo);
    }
    public void eliminarOdontologo(Long id) throws ResourceNotFoundExeption {
    Optional<Odontologo> odontologoAEliminar= buscarOdontologo(id);
    if(odontologoAEliminar.isPresent()){
        IOdontologoRepository.deleteById(id);
    }
       else{
           throw new ResourceNotFoundExeption("No se puede eliminar el paciente con ID:"+id+".- ya que no existe en nuestra BDD");
    }
    }
    public List<Odontologo> buscarTodosLosOdontologos(){
        return IOdontologoRepository.findAll();
    }

}
