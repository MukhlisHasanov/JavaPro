package de.ait.hw4_2.service;

import de.ait.hw4_2.entity.Car;
import de.ait.hw4_2.exception.CarNotFoundException;
import de.ait.hw4_2.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private final CarRepository repository;


    @Autowired
    public CarServiceImpl(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = repository.findAll();
        return cars;
    }

    @Override
    public Car findById(Long id) {
        return findAll()
                .stream()
                .filter(c -> c.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new CarNotFoundException("Car not found"));
        
    }
}
