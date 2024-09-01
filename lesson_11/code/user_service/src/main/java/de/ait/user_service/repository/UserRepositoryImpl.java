package de.ait.user_service.repository;

import de.ait.user_service.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jdk.jfr.internal.consumer.EventLog.update;

@Component
public class UserRepositoryImpl implements UserRepository{
    List<User> list = List.of(
            new User(1L, "jack", "jack@mail.com", "qwerty"),
            new User(2L, "john", "john@mail.com", "qwerty2"),
            new User(3L, "ann", "ann@mail.com", "qwerty3"),
            new User(4L, "lena", "lena@mail.com", "qwerty4")
    );
    private JdbcTemplate dataSource;

    @Override
    public User delete(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }



    @Override
    public User save(User entity) {
        if (entity.getId() == null) {
            return create(entity);
        } else {
            return update(entity);
        }
    }

    private User update(User entity){
        User user = list.stream()
                .filter(u -> u.getId().equals(entity.getId()))
                .findAny()
                .orElse(null);
        if (user!=null) {
            user.setName(entity.getName());
            user.setEmail(entity.getEmail());
            user.setPassword(entity.getPassword());
        }
        return null;
    }

    public User create(User user) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(dataSource)
                .usingGeneratedKeyColumns("id")
                .withTableName("t_user");

        Map<String,Object> parameters = new HashMap<>();
        parameters.put("name", user.getName());
        parameters.put("email", user.getEmail());
        parameters.put("password", user.getPassword());

        long newID = jdbcInsert.executeAndReturnKey(parameters).longValue();
        user.setId(newID);
        return user;
    }
}
