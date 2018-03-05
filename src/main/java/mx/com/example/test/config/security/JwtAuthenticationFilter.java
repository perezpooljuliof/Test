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

        Authentication auth = getAuthByToken(request);
        if(auth == null) {
            auth = getAuthByLogin(request);
        }

        System.out.println(auth);
        getAuthenticationManager().authenticate(auth);

        return auth;
    }

    /**
     * Get the User based Form Login
     *
     * @param request
     * @return
     */
    private Authentication getAuthByLogin(HttpServletRequest request) {
        String xAuth = request.getHeader("Authentication");
        System.out.println("xAuth:" + xAuth);

        Authentication auth = null;

        if(xAuth == null) {
            auth = new UsernamePasswordAuthenticationToken("", "");
            //getAuthenticationManager().authenticate(auth);
            return auth;
        }

        byte[] encodedHelloBytes = DatatypeConverter.parseBase64Binary(xAuth);
        String userAndPassword = new String(encodedHelloBytes, StandardCharsets.UTF_8) ;


        System.out.println("userAndPassword:" + userAndPassword);

        String[] partes = userAndPassword.split(":");
        // validate the value in xAuth
        if(partes.length != 2) {
            auth = new UsernamePasswordAuthenticationToken("", "");
            //getAuthenticationManager().authenticate(auth);
            return auth;
        }
        System.out.println("partes:" + partes[0] + "/" + partes[1]);

        // Create our Authentication and let Spring know about it
        auth = new UsernamePasswordAuthenticationToken(partes[0], partes[1]);
        System.out.println("auth:" + auth);

        return auth;
    }

    /**
     * Get the User base Authentication Token
     *
     * @return
     */
    private AbstractAuthenticationToken getAuthByToken(HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authentication = null;
        //extract token from header
        final String accessToken = request.getHeader("AuthenticationToken");
        if (null != accessToken) {
            //get and check whether token is valid ( from DB or file wherever you are storing the token)
            String[] partes = accessToken.split(":");

            if(partes.length != 2) {
                return authentication;
            }
            //Populate SecurityContextHolder by fetching relevant information using token
            authentication = new UsernamePasswordAuthenticationToken(partes[0], partes[1]);
        }

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