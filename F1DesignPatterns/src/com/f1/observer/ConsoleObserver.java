package com.f1.observer;

import com.f1.models.Driver;

public class ConsoleObserver implements RaceObserver {
    private final String name;

    public ConsoleObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(RaceEvent event) {
        Driver d = event.getDriver();
        System.out.printf("[%s] Lap %d - %s - Piloto: %s%n", name, event.getLap(), event.getMessage(), d != null ? d.getName() : "N/A");
    }
}
