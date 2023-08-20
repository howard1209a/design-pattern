package com.dyp.strategy.example1;

import com.dyp.strategy.example1.impl.RandomStrategy;
import com.dyp.strategy.example1.impl.WinningStrategy;

/**
 * @author howard
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int seed1 = Integer.parseInt("123");
        int seed2 = Integer.parseInt("456");

        Player player1 = new Player("Taro", new WinningStrategy(seed1));
        // Player player2 = new Player("Hana", new ProbStrategy(seed2));
        Player player2 = new Player("howard", new RandomStrategy(seed2));

        for (int i = 0; i < 10000; i++) {
            Hand hand1 = player1.nextHand();
            Hand hand2 = player2.nextHand();
            if (hand1.isStrongerThan(hand2)) {
                player1.win();
                player2.lose();
            } else if (hand1.isWeakerThan(hand2)) {
                player1.lose();
                player2.win();
            } else {
                player1.even();
                player2.even();
            }
        }

        System.out.println(player1);
        System.out.println(player2);
    }
}
