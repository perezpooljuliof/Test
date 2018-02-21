package mx.com.example.test.config.security;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;

public class UsernamePasswordWithTimeoutAuthenticationFilter extends
        UsernamePasswordAuthenticationFilter {

    private String timeoutParameter = "timeout";

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        System.out.println("UsernamePasswordWithTimeoutAuthenticationFilter.attemptAuthentication()>>>>>");
        if (!"POST".equals(request.getMethod())) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }


        String xAuth = request.getHeader("Authenticacion");
        System.out.println("xAuth:" + xAuth);

        Authentication auth = null;

        if(xAuth == null) {
            throw new AuthenticationServiceException("Header no encontrado: " + request.getMethod());
        }

        byte[] encodedHelloBytes = DatatypeConverter.parseBase64Binary(xAuth);
        String userAndPassword = new String(encodedHelloBytes, StandardCharsets.UTF_8) ;


        System.out.println("userAndPassword:" + userAndPassword);

        String[] partes = userAndPassword.split(":");
        // validate the value in xAuth
        if(partes.length != 2) {
            throw new AuthenticationServiceException("No se pudo obtener el usuario y el password: " + request.getMethod());
        }

        String username = partes[0];
        String password = partes[1];

        System.out.println(username + ":" + password);

        final UsernamePasswordWithTimeoutAuthenticationToken authRequest = new UsernamePasswordWithTimeoutAuthenticationToken(username, password, "10");

        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

}
