package com.dh.clinica.util;

import com.dh.clinica.login.AppUser;
import com.dh.clinica.login.AppUserRoles;
import com.dh.clinica.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final IUserRepository userRepository;
    @Autowired
    public DataLoader(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void run(ApplicationArguments args)  {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("admin");



        userRepository.save(new AppUser("admin","admin","admin",password,"admin",AppUserRoles.ADMIN));




    }
}
