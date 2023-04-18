package com.dh.integrador.login;

import com.dh.integrador.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {
    private UserRepository userRepository;

@Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

@Override
    public void run(ApplicationArguments args) throws Exception {
    BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        String password = bCryptPasswordEncoder.encode("admin");
        String password2 = bCryptPasswordEncoder.encode("password2");


    userRepository.save(new AppUser("admin","admin","admin@dh.com",password, AppUsuarioRoles.ADMIN));
    userRepository.save(new AppUser("Ricardito", "ricardito", "ricardito@digitalhouse.com", password2, AppUsuarioRoles.USER ));

}
}
