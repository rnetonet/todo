package br.ufba.tomorrow.todo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufba.tomorrow.todo.services.AutenticacaoService;

@RestController
public class AutenticacaoController {
    @Autowired
    private AutenticacaoService authenticationService;

    @PostMapping("/autenticar")
    public String autenticar(Authentication authentication) {
        return authenticationService.autenticar(authentication);
    }

}
