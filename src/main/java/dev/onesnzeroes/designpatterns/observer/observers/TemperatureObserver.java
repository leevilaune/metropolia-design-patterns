package dev.onesnzeroes.designpatterns.observer.observers;

import dev.onesnzeroes.designpatterns.observer.subjects.WeatherStation;

public class TemperatureObserver implements Observer {

    private final WeatherStation station;
    private String name;

    public TemperatureObserver(WeatherStation station, String name) {
        this.station = station;
        this.name = name;
    }

    @Override
    public void update() {
        double temperature = station.getTemperature();
        System.out.println(this.name + " temperature: " + temperature + " °C");
    }
}