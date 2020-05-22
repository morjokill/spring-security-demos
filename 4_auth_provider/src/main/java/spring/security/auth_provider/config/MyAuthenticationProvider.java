package spring.security.auth_provider.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import spring.security.auth_provider.model.User;
import spring.security.auth_provider.repository.UserRepository;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    private final UserRepository userRepository;

    public MyAuthenticationProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (!authentication.isAuthenticated()) {
            String login = authentication.getName();
            String password = authentication.getCredentials().toString();

            User user = userRepository.findByLogin(login);
            if (Objects.isNull(user) || !user.getPassword().equals(password)) {
                return null;
            }
        }
        return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
                authentication.getCredentials(),
                new ArrayList<>());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
