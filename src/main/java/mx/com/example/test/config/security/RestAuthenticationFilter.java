/*
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
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class RestAuthenticationFilter extends OncePerRequestFilter {

    static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
    static {
        AUTHORITIES.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {
                return "ROLE_USER";
            }
        });
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("RestAuthenticationFilter.doFilterInternal()>>>>>");
        String xAuth = request.getHeader("Authenticacion");
        System.out.println("xAuth:" + xAuth);

        //byte[] decodedBytes = Base64.decode(xAuth.getBytes());
        //String userAndPassword = new String(decodedBytes);

        byte[] encodedHelloBytes = DatatypeConverter.parseBase64Binary(xAuth);
        String userAndPassword = new String(encodedHelloBytes, StandardCharsets.UTF_8) ;

        //String userAndPassword = StringUtils.newStringUtf8(Base64.decodeBase64(xAuth));


        System.out.println("userAndPassword:" + userAndPassword);

        String[] partes = userAndPassword.split(":");
        // validate the value in xAuth
        if(partes.length != 2) {
            throw new SecurityException();
        }

        System.out.println("partes:" + partes[0] + "/" + partes[1]);

        // The token is 'valid' so magically get a user id from it
        //Long id = getUserIdFromToken(xAuth);

        // Create our Authentication and let Spring know about it
        Authentication auth = new UsernamePasswordAuthenticationToken(partes[0], partes[1], AUTHORITIES);
        System.out.println("auth:" + auth);
        SecurityContextHolder.getContext().setAuthentication(auth);

        filterChain.doFilter(request, response);
    }


    private boolean isValid(String token) {
        return token != null;
    }
}
*/