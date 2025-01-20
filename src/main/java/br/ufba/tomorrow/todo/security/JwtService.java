package br.ufba.tomorrow.todo.security;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Autowired
    private JwtEncoder jwtEncoder;

    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        Long expirationTimeLapse = 3600L;
        Instant expiration = now.plusSeconds(expirationTimeLapse);

        // FIXME: scopes is not being used
        String scopes = "openid profile email";

        var claims = JwtClaimsSet.builder().issuer("todo").issuedAt(now).expiresAt(expiration)
                .subject(authentication.getName()).claim("scope", scopes).build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
