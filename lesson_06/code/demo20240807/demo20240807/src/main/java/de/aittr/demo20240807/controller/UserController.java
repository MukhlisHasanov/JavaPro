package de.aittr.demo20240807.controller;

import de.aittr.demo20240807.entity.User;
import de.aittr.demo20240807.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    //"localhost:8080/users" GET

    @GetMapping("/users")
    public List<User> getAllUser() {
        return service.getAllUsers();
    }
}
