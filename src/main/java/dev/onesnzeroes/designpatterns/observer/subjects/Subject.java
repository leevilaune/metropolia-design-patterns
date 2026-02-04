package dev.onesnzeroes.designpatterns.observer.subjects;

import dev.onesnzeroes.designpatterns.observer.observers.Observer;

public interface Subject {

    void subscribe(Observer o);
    void unsubscribe(Observer o);
    void notifyObservers();
}
