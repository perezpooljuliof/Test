package mx.com.example.test.config.security;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class just returns HTTP code 401 (Unauthorized) when authentication fails, overriding default Spring’s redirecting.
 */
public class RestAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    final static Logger logger = Logger.getLogger("");

    @Override
    public void commence(final HttpServletRequest request,
                         final HttpServletResponse response,
                         final AuthenticationException authException) throws IOException, ServletException {
        logger.info("RestAuthenticationEntryPoint.commence()>>>>>");
        //Authentication failed, send error response.
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");

        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 : " + authException.getMessage());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName(getRealmName());
        super.afterPropertiesSet();
    }
}
