package dev.onesnzeroes.designpatterns.observer.subjects;

import dev.onesnzeroes.designpatterns.observer.Main;
import dev.onesnzeroes.designpatterns.observer.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation extends Thread implements Subject {

    private List<Observer> observers;
    private double temperature;

    public WeatherStation(){
        this.observers = new ArrayList<>();
        this.temperature = Math.random()*30;
    }

    @Override
    public void subscribe(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(Observer::update);
    }

    @Override
    public void run() {
        int multiplier = -2;
        while(true){
            try {
                sleep(1000*(long) (Math.random()*2));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(Math.random() > 0.5){
                multiplier = -2;
            }else{
                multiplier = 2;
            }
            this.temperature += Math.random()*multiplier;
            this.notifyObservers();
        }
    }

    public double getTemperature() {
        return this.temperature;
    }
}
