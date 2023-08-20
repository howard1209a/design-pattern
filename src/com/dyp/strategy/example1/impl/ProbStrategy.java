package com.dyp.strategy.example1.impl;

import com.dyp.strategy.example1.Hand;
import com.dyp.strategy.example1.Strategy;

import java.util.Random;

/**
 * @author howard
 * @version 1.0
 */
public class ProbStrategy implements Strategy {
    private Random random;
    private int preHandValue = 0;
    private int curHandValue = 0;
    private int[][] history = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    private int getSum(int hv) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[hv][i];
        }
        return sum;
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(curHandValue));
        int handValue;
        if (bet < history[curHandValue][0]) {
            handValue = 0;
        } else if (bet < history[curHandValue][0] + history[curHandValue][1]) {
            handValue = 1;
        } else {
            handValue = 2;
        }
        preHandValue = curHandValue;
        curHandValue = handValue;
        return Hand.getHand(curHandValue);
    }

    @Override
    public void study(boolean win) {
        if (win) {
            history[preHandValue][curHandValue]++;
        } else {
            history[preHandValue][(curHandValue + 1) % 3]++;
            history[preHandValue][(curHandValue + 2) % 3]++;
        }
    }
}
