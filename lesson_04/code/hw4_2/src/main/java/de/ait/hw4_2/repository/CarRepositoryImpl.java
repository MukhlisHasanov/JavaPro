package de.ait.hw4_2.repository;

import de.ait.hw4_2.entity.Car;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CarRepositoryImpl implements CarRepository {

    private static Map<Long, Car> map = new HashMap<>();
    static {
        map.put(1L, new Car(1L, "Nissan Skyline R34-GTR", 1999, "Midnight Purple"));
        map.put(2L, new Car(2L, "Toyota Supra MK4", 1998, "Mandarin"));
        map.put(3L, new Car(3L, "Mazda RX-7 FD", 1992, "Orange-Black"));
        map.put(4L, new Car(4L, "Toyota AE86 Trueno", 1987, "White"));
    }

    @Override
    public List<Car> findAll() {
        return map
                .values()
                .stream()
                .toList();
    }

    @Override
    public Car save(Car car) {
        return null;
    }

}

