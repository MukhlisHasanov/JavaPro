package de.ait.user_service.repository;

import de.ait.user_service.entity.User;

import java.util.List;

public interface UserRepository {
    User delete (Long id);
    List<User> findAll();
    User save (User user);

    User findById(Long id);


}
