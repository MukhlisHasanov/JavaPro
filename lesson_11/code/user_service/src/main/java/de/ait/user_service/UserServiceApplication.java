package de.ait.user_service;

import de.ait.user_service.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);

		User user = new User(1L, "name", "name@mail.ru", "qwerty");
		User user1 = new User("jack", "jack@mail.ru", "asdfgh");

		System.out.println(user1);

		User nick = User.builder()
				.id(3L)
				.name("nick")
				.build();
		System.out.println(nick);
	}

}
