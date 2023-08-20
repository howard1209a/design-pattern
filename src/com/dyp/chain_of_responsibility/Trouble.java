package com.dyp.chain_of_responsibility;

/**
 * @author howard
 * @version 1.0
 */
public class Trouble {
    private int num;

    public Trouble(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "[trouble" + num + "]";
    }
}
