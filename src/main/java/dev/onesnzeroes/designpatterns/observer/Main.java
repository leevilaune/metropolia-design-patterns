package dev.onesnzeroes.designpatterns.observer;

import dev.onesnzeroes.designpatterns.observer.observers.Observer;
import dev.onesnzeroes.designpatterns.observer.observers.TemperatureObserver;
import dev.onesnzeroes.designpatterns.observer.subjects.WeatherStation;

public class Main {

    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();

        Observer display1 = new TemperatureObserver(station,"obs1");
        Observer display2 = new TemperatureObserver(station,"obs2");
        Observer display3 = new TemperatureObserver(station, "obs3");

        station.subscribe(display1);
        station.subscribe(display2);
        station.subscribe(display3);

        station.start();

        try {
            Thread.sleep(10000);

            System.out.println("\nUnsubscribing display2\n");
            station.unsubscribe(display2);

            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nSimulation ended.");
        System.exit(0);
    }
}
