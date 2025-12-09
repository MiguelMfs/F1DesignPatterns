package com.f1;

import com.f1.models.Driver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceManager {
    private static RaceManager instance;
    private final List<Driver> drivers = new ArrayList<>();
    private int laps = 10;

    private RaceManager() { }

    public static synchronized RaceManager getInstance() {
        if (instance == null) {
            instance = new RaceManager();
        }
        return instance;
    }

    public void addDriver(Driver d) {
        drivers.add(d);
    }

    public List<Driver> getDrivers() {
        return Collections.unmodifiableList(drivers);
    }

    public void clearDrivers() {
        drivers.clear();
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }
}
