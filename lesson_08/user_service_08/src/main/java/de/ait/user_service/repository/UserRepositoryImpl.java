package de.ait.user_service.repository;

import de.ait.user_service.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository{
    List<User> list = new ArrayList<>(List.of(
            new User(1L, "jack", "jack@mail.com", "qwerty"),
            new User(2L, "john", "john@mail.com", "qwerty2"),
            new User(3L, "ann", "ann@mail.com", "qwerty3"),
            new User(4L, "lena", "lena@mail.com", "qwerty4")
    ));

    @Override
    public User delete(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(list);
    }

    @Override
    public User save(User entity) {
        long max = list.stream()
                .mapToLong(u -> u.getId().longValue())
                .max().getAsLong();
        entity.setId(++max);
        list.add(entity);
        return entity;
    }
}
