package com.dyp.observer.impl;

import com.dyp.observer.NumberGenerator;

public class IncrementalNumberGenerator extends NumberGenerator {
    private int endNum;
    private int step;
    private int num;

    public IncrementalNumberGenerator(int initNum, int endNum, int step) {
        this.num = initNum;
        this.endNum = endNum;
        this.step = step;
    }

    @Override
    public int getNumber() {
        return num;
    }

    @Override
    public void excute() {
        while (num <= endNum) {
            notifyObservers();
            num += step;
        }
    }
}
