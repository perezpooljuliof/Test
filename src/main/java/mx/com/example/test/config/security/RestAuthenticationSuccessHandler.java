package mx.com.example.test.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // We do not need to do anything extra on REST authentication success, because there is no page to redirect to
        System.out.println("RestAuthenticationSuccessHandler.onAuthenticationSuccess()>>>>>");

        String token = JwtTokenFactory.createAccessJwtToken(authentication);
        String refreshToken = JwtTokenFactory.createRefreshToken(authentication);

        response.setHeader("AuthenticationToken" , token);
        response.setHeader("RefreshToken" , refreshToken);

        //System.out.println("token:" + token);
        //System.out.println("refreshToken:" + refreshToken);
    }

}