package com.dyp.bridge.impl_side;

import com.dyp.bridge.impl_side.DisplayImpl;

/**
 * @author howard
 * @version 1.0
 */
public class StringDisplayImpl extends DisplayImpl {
    private String s;
    private int width;

    public StringDisplayImpl(String s) {
        this.s = s;
        this.width = s.getBytes().length;
    }

    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + s + "|");
    }

    @Override
    public void rawClose() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
