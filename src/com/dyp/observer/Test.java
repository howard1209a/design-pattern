package com.dyp.observer;

import com.dyp.observer.impl.DigitObserver;
import com.dyp.observer.impl.GraphObserver;
import com.dyp.observer.impl.IncrementalNumberGenerator;
import com.dyp.observer.impl.RandomNumberGenerator;

public class Test {
    public static void main(String[] args) {
        Observer o1 = new GraphObserver();
        Observer o2 = new DigitObserver();

        NumberGenerator numberGenerator1 = new RandomNumberGenerator();
        numberGenerator1.addObserver(o1);
        numberGenerator1.addObserver(o2);
        numberGenerator1.excute();

        NumberGenerator numberGenerator2 = new IncrementalNumberGenerator(10,50,5);
        numberGenerator2.addObserver(o1);
        numberGenerator2.addObserver(o2);
        numberGenerator2.excute();
    }
}
