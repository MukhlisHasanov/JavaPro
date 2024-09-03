package de.ait.hw4_2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Car {
    private Long id;
    private String model;
    private int year;
    private String color;

}
