package mx.com.example.test.config.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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

    public JwtAuthenticationFilter(String url) {
        super(url);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("JwtAuthenticationFilter.attemptAuthentication()>>>>>");

        //We get the user before validations
        Authentication auth = getAuthByToken(request);
        if(auth == null) {
            auth = getAuthByLogin(request);
        }

        //return a fully populated Authentication object (including granted authorities) if successful.
        auth = getAuthenticationManager().authenticate(auth);
        System.out.println("JwtAuthenticationFilter.attemptAuthentication.Auth:\n" + auth);
        return auth;
    }

    /**
     * Get the User based Form Login
     *
     * @param request
     * @return
     */
    private Authentication getAuthByLogin(HttpServletRequest request) {
        System.out.println("JwtAuthenticationFilter.getAuthByLogin()>>>>>>>>>>>>>>>");
        String xAuth = request.getHeader("Authentication");

        Authentication auth = null;

        if(xAuth == null) {
            auth = new UsernamePasswordAuthenticationToken("", "");
            //getAuthenticationManager().authenticate(auth);
            return auth;
        }

        byte[] encodedHelloBytes = DatatypeConverter.parseBase64Binary(xAuth);
        String userAndPassword = new String(encodedHelloBytes, StandardCharsets.UTF_8) ;

        String[] partes = userAndPassword.split(":");
        // validate the value in xAuth
        if(partes.length != 2) {
            auth = new UsernamePasswordAuthenticationToken("", "");
            //getAuthenticationManager().authenticate(auth);
            return auth;
        }

        // Create our Authentication and let Spring know about it
        auth = new UsernamePasswordAuthenticationToken(partes[0], partes[1]);

        return auth;
    }

    /**
     * Get the User base Authentication Token
     *
     * @return
     */
    private Authentication getAuthByToken(HttpServletRequest request) {
        System.out.println("JwtAuthenticationFilter.getAuthByToken()>>>>>>>>>>>>>>>");
        Authentication authentication = null;
        //extract token from header
        final String accessToken = request.getHeader("AuthenticationToken");
        if (null != accessToken) {
            //Populate SecurityContextHolder by fetching relevant information using token
            authentication = JwtTokenFactory.getAuthentication(accessToken);
        }

        System.out.println("AuthenticationToken:" + authentication);
        return authentication;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        System.out.println("JwtAuthenticationFilter.successfulAuthentication()>>>>>");

        // We set the Authentication token
        //response.setHeader("AuthenticationToken" , authResult.getPrincipal() + ":" + authResult.getCredentials());
        // As this authentication is in HTTP header, after success we need to continue the request normally
        // and return the response as if the resource was not secured at all

        chain.doFilter(request, response);
    }
}