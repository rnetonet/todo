package br.ufba.tomorrow.todo.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.ufba.tomorrow.todo.domain.Usuario;

public class UserDetailsImpl implements UserDetails {
    final Usuario usuario;

    public UserDetailsImpl(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
    }

    @Override
    public String getPassword() {
        return usuario.getSenha();
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
        return usuario.isAtivo();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    
}
