package mx.com.example.test.config.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DemoAuthenticationFilter extends OncePerRequestFilter {

    static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
    static {
        AUTHORITIES.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {
                return "ROLE_ADMIN";
            }
        });
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String xAuth = request.getHeader("X-Authorization");

        // validate the value in xAuth
        if(isValid(xAuth) == false){
            throw new SecurityException();
        }

        // The token is 'valid' so magically get a user id from it
        Long id = getUserIdFromToken(xAuth);

        // Create our Authentication and let Spring know about it
        Authentication auth = new UsernamePasswordAuthenticationToken("jperez", "jperez", AUTHORITIES);;
        SecurityContextHolder.getContext().setAuthentication(auth);

        filterChain.doFilter(request, response);
    }


    private boolean isValid(String token) {
        return token != null;
    }

    private Long getUserIdFromToken(String token) {
        return 1L;
    }

}