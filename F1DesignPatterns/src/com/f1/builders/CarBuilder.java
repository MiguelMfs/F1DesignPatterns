package com.f1.builders;

import com.f1.models.Car;

public class CarBuilder {
    private String team = "Equipe X";
    private int horsepower = 900;
    private double downforce = 1.0;

    public CarBuilder withTeam(String team) {
        this.team = team;
        return this;
    }

    public CarBuilder withHorsepower(int horsepower) {
        this.horsepower = horsepower;
        return this;
    }

    public CarBuilder withDownforce(double downforce) {
        this.downforce = downforce;
        return this;
    }

    public Car build() {
        return new Car(team, horsepower, downforce);
    }
}
