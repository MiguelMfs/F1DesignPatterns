package com.f1.observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RaceEventManager {
    private final List<RaceObserver> observers = new CopyOnWriteArrayList<>();

    public void register(RaceObserver o) {
        observers.add(o);
    }

    public void unregister(RaceObserver o) {
        observers.remove(o);
    }

    public void notify(RaceEvent event) {
        for (RaceObserver o : observers) {
            o.update(event);
        }
    }
}
