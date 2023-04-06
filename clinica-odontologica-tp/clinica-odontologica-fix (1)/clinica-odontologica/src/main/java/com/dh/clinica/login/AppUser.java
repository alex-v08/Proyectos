package com.dh.clinica.login;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity

public class AppUser implements UserDetails {
    @Id
    @SequenceGenerator(name = "app_user_sequence", sequenceName = "app_user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_user_sequence")
    private Integer id;

    private String username;
    private String name;
    private String lastName;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private AppUserRoles appUserRoles;


    public AppUser() {
    }

    public AppUser(String username, String name, String lastName, String password, String email, AppUserRoles appUserRoles) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.appUserRoles = appUserRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(appUserRoles.name());
        return Collections.singleton(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {

        return password;

    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
