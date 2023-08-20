package com.dyp.template_method;

/**
 * @author howard
 * @version 1.0
 */
public class StringDisplay extends AbstractDisplay {
    private String s;
    private int width;

    public StringDisplay(String s) {
        this.s = s;
        this.width = s.getBytes().length;
    }

    @Override
    void open() {
        printLine();
    }

    @Override
    void print() {
        System.out.println("|" + s + "|");
    }

    @Override
    void close() {
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
