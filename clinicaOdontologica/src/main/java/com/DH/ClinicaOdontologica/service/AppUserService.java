package com.DH.ClinicaOdontologica.service;

import com.DH.ClinicaOdontologica.repository.IUsuarioRepository;
import com.DH.ClinicaOdontologica.login.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {
    private com.DH.ClinicaOdontologica.repository.IUsuarioRepository IUsuarioRepository;

    @Autowired
    public AppUserService(IUsuarioRepository IUsuarioRepository) {
        this.IUsuarioRepository = IUsuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> usuarioBuscado= IUsuarioRepository.findByEmail(username);
        if(usuarioBuscado.isPresent()){
            return usuarioBuscado.get();
        }
        else{
            throw new UsernameNotFoundException("No existe el usuario con ese correo electronico");
        }


    }
}
