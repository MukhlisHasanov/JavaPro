package de.aittr.demo20240807.repository;

import de.aittr.demo20240807.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImp  implements UserRepository {
    private List<User> list = List.of(
            new User("jack", "jack@mail.com"),
            new User("ann", "ann@mail.com"),
            new User("nick", "nick@mail.com"),
            new User("jane", "jane@mail.com")
    );

    @Override
    public List<User> findALl() {
        return list;
    }
}
