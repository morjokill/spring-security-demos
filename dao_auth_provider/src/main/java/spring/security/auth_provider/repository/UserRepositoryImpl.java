package spring.security.auth_provider.repository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import spring.security.auth_provider.model.User;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepositoryImpl implements UserRepository {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    Map<String, User> dbMock = new HashMap<String, User>() {{
        put("obi_wan", new User("obi_wan", passwordEncoder.encode("kenobi")));
        put("naruto", new User("naruto", passwordEncoder.encode("uzumaki")));
    }};

    @Override
    public User findByLogin(String login) {
        return dbMock.get(login);
    }
}
