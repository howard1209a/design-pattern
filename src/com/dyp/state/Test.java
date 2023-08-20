package com.dyp.state;

import com.dyp.state.impl.SafeFrame;

/**
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        SafeFrame safeFrame = new SafeFrame("state sample");
        while (true) {
            for (int i = 0; i < 24; i++) {
                safeFrame.setClock(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
