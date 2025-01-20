package br.ufba.tomorrow.todo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.ufba.tomorrow.todo.security.JwtService;

@Service
public class AutenticacaoService {
    @Autowired
    private JwtService jwtService;

    public String autenticar(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }
}
