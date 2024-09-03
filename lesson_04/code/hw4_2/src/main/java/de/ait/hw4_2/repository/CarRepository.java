package de.ait.hw4_2.repository;

import de.ait.hw4_2.entity.Car;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarRepository {
    List<Car> findAll();
    Car save(Car car);

}
