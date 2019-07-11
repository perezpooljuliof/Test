package mx.com.example.test.config.security;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PermitAllRestAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    /*
    @Autowired
    protected Log logger;
    */

    @Override
    public void commence(final HttpServletRequest request,
                         final HttpServletResponse response,
                         final AuthenticationException authException) throws IOException, ServletException {
        System.out.println("PermitAllRestAuthenticationEntryPoint.commence()>>>>>");
        //Authentication failed, send error response.
        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");

        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 200 : " + authException.getMessage());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PermitAllRestAuthenticationEntryPoint.afterPropertiesSet()>>>>>");
        setRealmName(getRealmName());
        super.afterPropertiesSet();
    }
}
