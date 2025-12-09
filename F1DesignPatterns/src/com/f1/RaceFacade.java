package com.f1;

import com.f1.builders.CarBuilder;
import com.f1.builders.DriverBuilder;
import com.f1.models.Car;
import com.f1.models.Driver;
import com.f1.observer.RaceEventManager;
import com.f1.observer.ConsoleObserver;

import java.util.Scanner;

public class RaceFacade {
    private final RaceManager manager = RaceManager.getInstance();
    private final RaceEventManager eventManager = new RaceEventManager();

    public RaceFacade() {
        // registro de observadores default
        eventManager.register(new ConsoleObserver("Painel"));
    }

    public RaceEventManager getEventManager() {
        return eventManager;
    }

    public void interactiveSetupAndRun() {
        Scanner sc = new Scanner(System.in);
        manager.clearDrivers();

        System.out.println("=== Setup da Corrida de F1 ===");
        System.out.print("Numero de pilotos: ");
        int nPilotos = readInt(sc, 1, 22);

        for (int i = 1; i <= nPilotos; i++) {
            System.out.printf("Piloto %d - Nome: ", i);
            String nome = sc.nextLine().trim();
            System.out.printf("Piloto %d - Numero (ex: 7): ", i);
            int numero = readInt(sc, 1, 99, sc);

            System.out.printf("Piloto %d - Equipe: ", i);
            String equipe = sc.nextLine().trim();

            System.out.printf("Piloto %d - Potencia (HP) (ex: 800): ", i);
            int hp = readInt(sc, 300, 1200, sc);

            System.out.printf("Piloto %d - Downforce (ex: 0.5): ", i);
            double df = readDouble(sc, 0.1, 5.0, sc);

            Car car = new CarBuilder()
                    .withTeam(equipe)
                    .withHorsepower(hp)
                    .withDownforce(df)
                    .build();

            Driver driver = new DriverBuilder()
                    .withName(nome.isEmpty() ? ("Piloto" + i) : nome)
                    .withNumber(numero)
                    .withCar(car)
                    .build();

            manager.addDriver(driver);
            System.out.println("Adicionado: " + driver);
        }

        System.out.print("Numero de voltas: ");
        int laps = readInt(sc, 1, 300, sc);
        manager.setLaps(laps);

        // possibilitar que o usuário adicione observador extra
        System.out.print("Deseja ver atualizações detalhadas no console durante a corrida? (s/n): ");
        String ans = sc.nextLine().trim().toLowerCase();
        if (ans.equals("s") || ans.equals("sim")) {
            eventManager.register(new ConsoleObserver("Detalhe"));
        }

        // iniciando simulação
        RaceSimulator sim = new RaceSimulator(eventManager);
        sim.runRace();
    }

    private int readInt(Scanner sc, int min, int max) {
        return readInt(sc, min, max, sc);
    }

    private int readInt(Scanner sc, int min, int max, Scanner scannerToUse) {
        while (true) {
            String line = scannerToUse.nextLine().trim();
            try {
                int v = Integer.parseInt(line);
                if (v < min || v > max) throw new NumberFormatException();
                return v;
            } catch (Exception e) {
                System.out.printf("Valor invalido. Informe um numero entre %d e %d: ", min, max);
            }
        }
    }

    private double readDouble(Scanner sc, double min, double max, Scanner scannerToUse) {
        while (true) {
            String line = scannerToUse.nextLine().trim();
            try {
                double v = Double.parseDouble(line.replace(',', '.'));
                if (v < min || v > max) throw new NumberFormatException();
                return v;
            } catch (Exception e) {
                System.out.printf("Valor invalido. Informe um numero entre %.2f e %.2f: ", min, max);
            }
        }
    }
}
