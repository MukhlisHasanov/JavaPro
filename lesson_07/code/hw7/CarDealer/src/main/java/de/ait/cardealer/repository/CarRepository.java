package de.ait.cardealer.repository;

import de.ait.cardealer.entity.Car;

import java.util.List;

public interface CarRepository {
    List<Car> getAllCars();
//    List<Car> getCarByBrand(String brand);
//    List<Car> getCarById(Long id);
    Car save (Car entity);
    Car delete (Long id);
}
