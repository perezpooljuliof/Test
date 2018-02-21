package mx.com.example.test.config.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
    static {
        AUTHORITIES.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {
                return "ROLE_USER";
            }
        });
    }


    public JwtAuthenticationFilter() {
        super("/**");
    }

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("JwtAuthenticationFilter.requiresAuthentication()>>>>>");
        return true;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("JwtAuthenticationFilter.attemptAuthentication()>>>>>");
        String xAuth = request.getHeader("Authenticacion");
        System.out.println("xAuth:" + xAuth);

        Authentication auth = null;

        if(xAuth == null) {
            auth = new UsernamePasswordAuthenticationToken("", "");
            getAuthenticationManager().authenticate(auth);
            return auth;
        }

        byte[] encodedHelloBytes = DatatypeConverter.parseBase64Binary(xAuth);
        String userAndPassword = new String(encodedHelloBytes, StandardCharsets.UTF_8) ;


        System.out.println("userAndPassword:" + userAndPassword);

        String[] partes = userAndPassword.split(":");
        // validate the value in xAuth
        if(partes.length != 2) {
            auth = new UsernamePasswordAuthenticationToken("", "");
            getAuthenticationManager().authenticate(auth);
            return auth;
        }
        System.out.println("partes:" + partes[0] + "/" + partes[1]);

        // Create our Authentication and let Spring know about it
        auth = new UsernamePasswordAuthenticationToken(partes[0], partes[1]);
        System.out.println("auth:" + auth);
        getAuthenticationManager().authenticate(auth);

        return auth;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        System.out.println("JwtAuthenticationFilter.successfulAuthentication()>>>>>");

        // As this authentication is in HTTP header, after success we need to continue the request normally
        // and return the response as if the resource was not secured at all
        chain.doFilter(request, response);
    }

}