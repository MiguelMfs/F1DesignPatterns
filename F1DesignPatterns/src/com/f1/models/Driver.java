package com.f1.models;

public class Driver {
    private final String name;
    private final int number;
    private final Car car;

    public Driver(String name, int number, Car car) {
        this.name = name;
        this.number = number;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return String.format("#%d %s - %s", number, name, car);
    }
}
