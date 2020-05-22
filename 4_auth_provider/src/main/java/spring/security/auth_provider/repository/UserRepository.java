package spring.security.auth_provider.repository;

import spring.security.auth_provider.model.User;

public interface UserRepository {
    User findByLogin(String login);
}
