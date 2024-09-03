package de.ait.hw4_2.service;

import de.ait.hw4_2.entity.Car;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarService {
    List<Car> findAll();
    Car findById(Long id);
}
