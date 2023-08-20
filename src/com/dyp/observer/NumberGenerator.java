package com.dyp.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberGenerator {
    private List<Observer> list = new ArrayList<>();

    public void addObserver(Observer observer) {
        list.add(observer);
    }

    public void deleteObserver(Observer observer) {
        list.remove(observer);
    }

    protected void notifyObservers() {
        list.stream().forEach(o -> {
            o.update(this);
        });
    }

    public abstract int getNumber();

    public abstract void excute();
}
