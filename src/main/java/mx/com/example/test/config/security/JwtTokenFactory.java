
package mx.com.example.test.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class JwtTokenFactory {
    private String tokenIssuer = "jperezp";
    private String tokenSigningKey = "secretKey";
    private long refreshTokenExpTime = 300000l;

    public JwtTokenFactory() {
    }


    public String createAccessJwtToken(Authentication userContext) {
        if (userContext == null)
            throw new IllegalArgumentException("Cannot create JWT Token without username");


        Claims claims = Jwts.claims().setSubject((String) userContext.getPrincipal());
        claims.put("scopes", userContext.getAuthorities());

        Date currentTime = new Date();

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuer(tokenIssuer)
                .setIssuedAt(currentTime)
                .setExpiration(new Date(currentTime.getTime() + refreshTokenExpTime))
                .signWith(SignatureAlgorithm.HS512, tokenSigningKey)
                .compact();

        return token;
    }

    public String createRefreshToken(Authentication userContext) {
        if (userContext == null) {
            throw new IllegalArgumentException("Cannot create JWT Token without username");
        }

        Date currentTime = new Date();

        Claims claims = Jwts.claims().setSubject((String) userContext.getPrincipal());
        claims.put("scopes", Arrays.asList(new String[]{"REFRESH_TOKEN"}));

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuer(tokenIssuer)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(currentTime)
                .setExpiration(new Date(currentTime.getTime() + refreshTokenExpTime))
                .signWith(SignatureAlgorithm.HS512, tokenSigningKey)
                .compact();

        return token;
    }
}
