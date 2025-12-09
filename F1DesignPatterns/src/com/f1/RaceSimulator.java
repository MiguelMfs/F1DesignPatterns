package com.f1;

import com.f1.models.Driver;
import com.f1.observer.RaceEvent;
import com.f1.observer.RaceEventManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RaceSimulator {
    private final RaceEventManager eventManager;
    private final Random rnd = new Random();

    public RaceSimulator(RaceEventManager eventManager) {
        this.eventManager = eventManager;
    }

    public void runRace() {
        RaceManager manager = RaceManager.getInstance();
        List<Driver> drivers = new ArrayList<>(manager.getDrivers());
        int laps = manager.getLaps();

        if (drivers.isEmpty()) {
            System.out.println("Nenhum piloto cadastrado. Abortando corrida.");
            return;
        }

        System.out.printf("Iniciando corrida com %d pilotos e %d voltas.%n", drivers.size(), laps);
        // positions list
        List<Driver> positions = new ArrayList<>(drivers);

        for (int lap = 1; lap <= laps; lap++) {
            // shuffle with some bias using horsepower/downforce
            positions = simulateLap(positions);
            // notify lap completion for leader
            Driver leader = positions.get(0);
            eventManager.notify(new RaceEvent(lap, "Líder da volta", leader));

            // random events
            if (rnd.nextDouble() < 0.2) {
                Driver unlucky = positions.get(rnd.nextInt(positions.size()));
                eventManager.notify(new RaceEvent(lap, "Incidente (parcial)", unlucky));
            }
        }

        System.out.println("Corrida finalizada. Resultado final:");
        for (int i = 0; i < positions.size(); i++) {
            System.out.printf("%d) %s%n", i+1, positions.get(i));
        }
    }

    private List<Driver> simulateLap(List<Driver> current) {
        List<Double> scores = new ArrayList<>();
        for (Driver d : current) {
            double s = d.getCar().getHorsepower() * 0.7 + d.getCar().getDownforce() * 100 + rnd.nextDouble()*100;
            scores.add(s);
        }
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < current.size(); i++) idx.add(i);
        Collections.sort(idx, (a,b) -> Double.compare(scores.get(b), scores.get(a)));

        List<Driver> next = new ArrayList<>();
        for (int i : idx) next.add(current.get(i));
        return next;
    }
}
