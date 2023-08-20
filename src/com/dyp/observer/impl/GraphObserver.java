package com.dyp.observer.impl;

import com.dyp.observer.NumberGenerator;
import com.dyp.observer.Observer;

public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator numberGenerator) {
        int count = numberGenerator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println("");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
