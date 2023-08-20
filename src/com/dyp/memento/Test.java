package com.dyp.memento;

import com.dyp.memento.game.Gamer;
import com.dyp.memento.game.Memento;

import java.io.IOException;

/**
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String path = "src/com/dyp/memento/memento.txt";
        Memento memento = Memento.load(path);
        Gamer gamer = new Gamer(100);
        if (memento != null) {
            gamer.restoreMemento(memento);
        }
        memento = gamer.createMemento();
        for (int i = 0; i < 100; i++) {
            System.out.println("====== " + i);
            System.out.println("当前状态: " + gamer);
            gamer.bet();
            if (gamer.getMoney() > memento.getMoney()) {
                memento = gamer.createMemento();
                if (memento.getMoney() > 400) {
                    memento.save(path);
                }
                System.out.println("所持金钱增加，保存快照");
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                gamer.restoreMemento(memento);
                System.out.println("所持金钱减少过多，恢复快照");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
