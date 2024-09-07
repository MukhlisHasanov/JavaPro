package de.ait.cardealer.service;

import de.ait.cardealer.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    List<Car> getCarByBrand(String brand);
    Car getCarById(Long id);
    Car save (Car entity);
    Car delete (Long id);
}
