package com.dyp.memento.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description: TODO
 */
public class Gamer {
    private int money;
    private List<String> fruits = new ArrayList<>();
    private Random random = new Random();
    private static String[] fruitsname = {
            "苹果", "葡萄", "香蕉", "橘子"
    };

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("所持金钱增加了");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("所持金钱减半了");
        } else if (dice == 6) {
            String fruit = getFruit();
            fruits.add(fruit);
            System.out.println("获得了水果(" + fruit + ")");
        } else {
            System.out.println("什么都没有发生");
        }
    }

    public Memento createMemento() {
        Memento memento = new Memento(money);
        for (String fruit : fruits) {
            if (fruit.startsWith("好吃的")) {
                memento.addFruit(fruit);
            }
        }
        return memento;
    }

    public void restoreMemento(Memento memento) {
        money = memento.getMoney();
        fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "money = " + money + ",fruits = " + fruits;
    }

    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "好吃的 ";
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }
}
