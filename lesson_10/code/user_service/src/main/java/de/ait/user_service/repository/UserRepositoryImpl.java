package de.ait.user_service.repository;

import de.ait.user_service.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class UserRepositoryImpl implements UserRepository{
    List<User> list = List.of(
            new User(1L, "jack", "jack@mail.com", "qwerty"),
            new User(2L, "john", "john@mail.com", "qwerty2"),
            new User(3L, "ann", "ann@mail.com", "qwerty3"),
            new User(4L, "lena", "lena@mail.com", "qwerty4")
    );

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User delete(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }
}
