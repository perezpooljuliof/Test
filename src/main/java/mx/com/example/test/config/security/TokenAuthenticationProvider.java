package mx.com.example.test.config.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Date;

/**
 * Returns a fully authenticated object including credentials,
 * may return null if the AuthenticationProvider is unable to support authentication of the passed Authentication object
 */

public class TokenAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("TokenAuthenticationProvider.authenticate()>>>>>>>>>>>>>>>>");
        CustomAuthenticationToken customAuthenticationToken = null;

        if(authentication == null) {
            System.out.println("authentication == null");
            return null;
        }

        if(!(authentication instanceof CustomAuthenticationToken)) {
            System.out.println("authentication != CustomAuthenticationToken");
            return null;
        }

        customAuthenticationToken = (CustomAuthenticationToken) authentication;

        Date now = new Date();
        Date expirationDate = customAuthenticationToken.getExpiration();
        System.out.println("now:" + now + " expirationDate:" + expirationDate);
        if(now.getTime() > expirationDate.getTime()) {
            return null;
        }

        return customAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
