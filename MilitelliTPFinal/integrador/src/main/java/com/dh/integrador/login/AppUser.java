package com.dh.integrador.login;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collections;
import java.util.Collection;



@Entity
public class AppUser implements UserDetails {


    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;
    private String nombre;
    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private AppUsuarioRoles appUsuarioRoles;

    public AppUser() {
    }

    public AppUser(String nombre, String username, String email, String password, AppUsuarioRoles appUsuarioRoles) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.password = password;
        this.appUsuarioRoles = appUsuarioRoles;
    }
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUsuarioRoles.name());
        return Collections.singletonList(grantedAuthority);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    public AppUsuarioRoles getAppUsuarioRoles() {
        return appUsuarioRoles;
    }

    public void setAppUsuarioRoles(AppUsuarioRoles appUsuarioRoles) {
        this.appUsuarioRoles = appUsuarioRoles;
    }
}
