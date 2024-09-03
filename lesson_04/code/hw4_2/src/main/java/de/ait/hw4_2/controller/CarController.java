package de.ait.hw4_2.controller;

import de.ait.hw4_2.entity.Car;
import de.ait.hw4_2.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarController {
    private final CarService service;

    @Autowired
    public CarController(@Qualifier("carServiceImpl") CarService service) {
        this.service = service;
    }

    public List<Car> getAllCars() {
        List<Car> cars = service.findAll();
        return cars;
    }

    public Car getCarById(Long id) {
        return service.findById(id);
    }
}
