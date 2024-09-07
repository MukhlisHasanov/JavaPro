package de.ait.cardealer.repository;

import de.ait.cardealer.entity.Car;
import de.ait.cardealer.exception.CarNotFoundException;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class CarRepositoryImpl implements CarRepository {

    List<Car> list = new ArrayList<>(List.of(
            new Car(1L, "BMW", "M5", 2024, "black", new BigDecimal(160_000)),
            new Car(2L, "Mercedes", "CLS 55", 2024, "white", new BigDecimal( 140_000)),
            new Car(3L, "AUDI", "RS7", 2024, "gray", new BigDecimal(150_000)),
            new Car(4L, "Porsche", "Panamera", 2024, "blue", new BigDecimal(170_000))

    ));

    @Override
    public List<Car> getAllCars() {
        return list;
    }
//
//    @Override
//    public List<Car> getCarByBrand(String brand) {
//        return List.of();
//    }
//
//    @Override
//    public List<Car> getCarById(Long id) {
//        return List.of();
//    }


    @Override
    public Car save(Car entity) {
        long max = list.stream()
                .mapToLong(Car::getId)
                .max()
                .orElse(0L);
        entity.setId(++max);
        list.add(entity);
        return entity;
    }

    @Override
    public Car delete(Long id) {
        Optional<Car> carToDelete = list.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst();
        if (carToDelete.isPresent()) {
            list.remove(carToDelete.get());
            return carToDelete.get();
        } else {
            throw new CarNotFoundException("Car with ID " + id + " not found");
        }
    }
}
