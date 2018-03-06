
package mx.com.example.test.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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

        Object principal = userContext.getPrincipal();
        List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority> ) userContext.getAuthorities();
        String username = (principal instanceof User)?((User) principal).getUsername():principal.toString();
        List<String> permisos = new ArrayList<>();
        for(GrantedAuthority authority: grantedAuthorities) {
            permisos.add(authority.getAuthority());
        }


        Claims claims = Jwts.claims().setSubject(username);
        claims.put("scopes", permisos);
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

        Object principal = userContext.getPrincipal();
        String username = (principal instanceof User)?((User) principal).getUsername():principal.toString();

        Date currentTime = new Date();

        Claims claims = Jwts.claims().setSubject(username);
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
        System.out.println("JwtTokenFactory.getAuthentication()>>>>>");
        UsernamePasswordAuthenticationToken user = null;
        //String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(tokenSigningKey)
                    .parseClaimsJws(token);

            String username = claims.getBody().getSubject();
            List<String> scopes = (List<String>) claims.getBody().get("scopes");
            Date expiration = claims.getBody().getExpiration();
            Date issuedAt = claims.getBody().getIssuedAt();

            List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
            for(String scope: scopes) {
                roles.add(new GrantedAuthority(){
                    @Override
                    public String getAuthority() {
                        return scope;
                    }

                });
            };


            user = new UsernamePasswordAuthenticationToken(username, null, roles);
            System.out.println("subject:" + username + " scopes:" + scopes + " issuedAt:" + issuedAt + " expiration:" + expiration);
        }

        return user;
    }
}
