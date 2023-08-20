package com.dyp.strategy.example1;

public interface Strategy {
    Hand nextHand();

    void study(boolean win);
}
