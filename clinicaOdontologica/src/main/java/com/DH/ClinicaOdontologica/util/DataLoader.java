package com.DH.ClinicaOdontologica.util;

import com.DH.ClinicaOdontologica.login.AppUser;
import com.DH.ClinicaOdontologica.login.AppUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.DH.ClinicaOdontologica.repository.IUsuarioRepository;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    IUsuarioRepository IUsuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        String password= "admin";
        IUsuarioRepository.save(new AppUser("admin","admin","admin@dh.com",bCryptPasswordEncoder.encode(password), AppUserRole.ROLE_ADMIN));

    }
}
