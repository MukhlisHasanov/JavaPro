package de.aittr.demo20240807.repository;

import de.aittr.demo20240807.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository {
    public List<User> findALl();
}
