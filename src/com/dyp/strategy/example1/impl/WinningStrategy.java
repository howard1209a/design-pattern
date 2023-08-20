package com.dyp.strategy.example1.impl;

import com.dyp.strategy.example1.Hand;
import com.dyp.strategy.example1.Strategy;

import java.util.Random;

/**
 * @author howard
 * @version 1.0
 */
public class WinningStrategy implements Strategy {
    private Random random;
    private boolean won = false;
    private Hand preHand;

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!won) {
            preHand = Hand.getHand(random.nextInt(3));
        }
        return preHand;
    }


    @Override
    public void study(boolean win) {
        won = win;
    }
}
