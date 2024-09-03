package de.ait.hw4_2;

import de.ait.hw4_2.controller.CarController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Hw42Application {

    public static void main(String[] args) {

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(".app");
//        CarController controller = context.getBean(CarController.class);

//        System.out.println(controller.getAllCars());
        SpringApplication.run(Hw42Application.class, args);
    }

}
