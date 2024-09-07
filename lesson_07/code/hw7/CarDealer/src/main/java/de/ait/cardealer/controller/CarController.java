package de.ait.cardealer.controller;

import de.ait.cardealer.entity.Car;
import de.ait.cardealer.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @GetMapping("/autos")
    public List<Car> getAllCars(@RequestParam(name = "brand", required = false) String brand) {
        if (brand == null || brand.isEmpty()) {
            return service.getAllCars();
        } else {
            return service.getCarByBrand(brand);
        }
    }

    @GetMapping("/autos/{id}")
    public Car getCarById(@PathVariable Long id) {
        return service.getCarById(id);
    }

    @PostMapping("/autos")
    public Car save(@RequestBody Car entity) {
        service.save(entity);
        return entity;
    }

    @DeleteMapping("/autos/{id}")
    public Car delete(@PathVariable Long id) {
        Car car = service.getCarById(id);
        service.delete(id);
        return car;
    }
}
