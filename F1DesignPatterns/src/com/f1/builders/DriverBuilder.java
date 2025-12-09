package com.f1.builders;

import com.f1.models.Driver;
import com.f1.models.Car;

public class DriverBuilder {
    private String name = "Piloto";
    private int number = 0;
    private Car car = null;

    public DriverBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public DriverBuilder withNumber(int number) {
        this.number = number;
        return this;
    }

    public DriverBuilder withCar(Car car) {
        this.car = car;
        return this;
    }

    public Driver build() {
        if (car == null) {
            throw new IllegalStateException("Driver precisa de um carro.");
        }
        return new Driver(name, number, car);
    }
}
