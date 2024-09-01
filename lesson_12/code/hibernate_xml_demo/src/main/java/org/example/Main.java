package org.example;

import org.example.entity.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HibernateAnnotationRepositoryDemo repository = new HibernateAnnotationRepositoryDemo();
        List<User> users = repository.findAll();
        System.out.println(users);
        System.out.println("-------------- find By ID -------------");
        System.out.println(repository.findById(2L));
        System.out.println("-------------- save -------------");
        User user = repository.create(new User(null, "Misha", "misha@mail.com", "asdfgdh"));
        System.out.println(user);

    }
}