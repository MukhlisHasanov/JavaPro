package de.ait.cardealer.service;

import de.ait.cardealer.entity.Car;
import de.ait.cardealer.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository repository;

    @Override
    public List<Car> getAllCars() {
        return repository.getAllCars();
    }

    @Override
    public List<Car> getCarByBrand(String brand) {
        return getAllCars()
                .stream()
                .filter(car->car.getBrand().equalsIgnoreCase(brand))
                .toList();
    }

    @Override
    public Car getCarById(Long id) {
        return repository
                .getAllCars()
                .stream()
                .filter(car -> car.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Car with ID " + id + " not found"));
    }

    @Override
    public Car save(Car entity) {
        return repository.save(entity);
    }

    @Override
    public Car delete(Long id) {
        return repository.delete(id);
    }
}
