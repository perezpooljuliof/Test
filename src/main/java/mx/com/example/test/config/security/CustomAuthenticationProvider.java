package mx.com.example.test.config.security;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.util.StringUtils;

/*
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final String NONCE_FIELD_SEPARATOR = ":";

    private String key = "KEY";

    private long nonceValiditySeconds=10;


    protected final MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Override
    public final Authentication authenticate(Authentication authentication) {
        final UsernamePasswordWithTimeoutAuthenticationToken authenticationToken = (UsernamePasswordWithTimeoutAuthenticationToken)authentication;
        validateTimeout(authenticationToken);
        //lógica de comprobación de usuario y contrase&nacute;a
        return createSuccessAuthentication(authenticationToken);
    }

    @Override
    public final boolean supports(Class<?> authentication) {
        return UsernamePasswordWithTimeoutAuthenticationToken.class.isAssignableFrom(authentication);
    }

    public long getNonceValiditySeconds() {
        return nonceValiditySeconds;
    }

    public void setNonceValiditySeconds(long nonceValiditySeconds) {
        this.nonceValiditySeconds = nonceValiditySeconds;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private void validateTimeout(
            UsernamePasswordWithTimeoutAuthenticationToken authenticationToken) {
        if(StringUtils.isEmpty( authenticationToken.getTimeout())){
            final String msg="Timeout signature not present.";
            Log.error(msg);
            throw new BadCredentialsException(msg);
        }
        final long timeOutTime=extractNonceValue(authenticationToken.getTimeout());

        if (isNonceExpired(timeOutTime)){
            final String msg="Login timeout";
            Log.error(msg);
            throw new NonceExpiredException(msg);
        }
    }

}
*/
