package com.dyp.strategy.example1.impl;

import com.dyp.strategy.example1.Hand;
import com.dyp.strategy.example1.Strategy;

import java.util.Random;

/**
 * @author howard
 * @version 1.0
 */
public class RandomStrategy implements Strategy {
    private Random random;

    public RandomStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        return Hand.getHand(random.nextInt(3));
    }

    @Override
    public void study(boolean win) {
    }
}
