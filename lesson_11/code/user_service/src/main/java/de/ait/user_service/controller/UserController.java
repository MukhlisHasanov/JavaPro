package de.ait.user_service.controller;


import de.ait.user_service.entity.User;
import de.ait.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    // "/api/users/2" GET
    @GetMapping("/api/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getById(id);
    }

    // "/api/users?nane=jack
    // "/api/users" GET
    @GetMapping("/api/users")
    public List<User> getAllUsers(@RequestParam(name = "name", required = false, defaultValue = "") String name){
        return service.getAll();
    }




}
