package spring.security.auth_provider.repository;

import org.springframework.stereotype.Repository;
import spring.security.auth_provider.model.User;

public interface UserRepository {
    User findByLogin(String login);
}
