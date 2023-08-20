package com.dyp.chain_of_responsibility;

import com.dyp.chain_of_responsibility.impl.LimitSupport;
import com.dyp.chain_of_responsibility.impl.NoSupport;
import com.dyp.chain_of_responsibility.impl.OddSupport;
import com.dyp.chain_of_responsibility.impl.SpecialSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author howard
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);

        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        for (int i = 0; i < 500; i += 33) {
            alice.support(new Trouble(i));
        }

        System.out.println("");
        List<Support> list = new ArrayList<>();
        list.add(alice);
        list.add(bob);
        list.add(charlie);
        list.add(diana);
        list.add(elmo);
        list.add(fred);
        for (int i = 0; i < 500; i += 33) {
            Trouble trouble = new Trouble(i);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).resolve(trouble)) {
                    list.get(j).done(trouble);
                    break;
                } else if (j == list.size() - 1) {
                    list.get(j).fail(trouble);
                }
            }
        }
    }
}
