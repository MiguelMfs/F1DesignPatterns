package com.f1.observer;

import com.f1.models.Driver;

public class RaceEvent {
    private final int lap;
    private final String message;
    private final Driver driver;

    public RaceEvent(int lap, String message, Driver driver) {
        this.lap = lap;
        this.message = message;
        this.driver = driver;
    }

    public int getLap() {
        return lap;
    }

    public String getMessage() {
        return message;
    }

    public Driver getDriver() {
        return driver;
    }
}
