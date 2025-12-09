package com.f1.models;

public class Car {
    private final String team;
    private final int horsepower;
    private final double downforce; // simplificação

    public Car(String team, int horsepower, double downforce) {
        this.team = team;
        this.horsepower = horsepower;
        this.downforce = downforce;
    }

    public String getTeam() {
        return team;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public double getDownforce() {
        return downforce;
    }

    @Override
    public String toString() {
        return String.format("%s (HP:%d, DF:%.2f)", team, horsepower, downforce);
    }
}
