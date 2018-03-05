
package mx.com.example.test.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class JwtTokenFactory {
    private static String tokenIssuer = "jperezp";
    private static String tokenSigningKey = "secretKey";
    private static long refreshTokenExpTime = 300000l;
    private static final String HEADER_STRING = "AuthenticationToken";

    public JwtTokenFactory() {
    }


    public static String createAccessJwtToken(Authentication userContext) {
        if (userContext == null)
            throw new IllegalArgumentException("Cannot create JWT Token without username");


        Claims claims = Jwts.claims().setSubject((String) userContext.getPrincipal());
        System.out.println("Autorities:" + userContext.getAuthorities());
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

    public static String createRefreshToken(Authentication userContext) {
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

    static Authentication getAuthentication(String token) {
        //String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            /*
            String user = Jwts.parser()
                    .setSigningKey(tokenSigningKey)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            */
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(tokenSigningKey)
                    .parseClaimsJws(token);

            String subject = claims.getBody().getSubject();
            Object scopes = claims.getBody().get("scopes");
            System.out.println("subject:" + subject + " scopes:" + scopes);
        }

        return null;
    }
}
