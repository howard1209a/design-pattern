package com.dyp.prototype;

/**
 * @author howard
 * @version 1.0
 */
public class UnderlinePen implements Product, Cloneable {
    private char c;

    public UnderlinePen(char c) {
        this.c = c;
    }

    @Override
    public Product createCopy() throws CloneNotSupportedException {
        return (Product) clone();
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.print(" ");
        for (int i = 0; i < length; i++) {
            System.out.print(c);
        }
        System.out.println("");
    }

    public char getC() {
        return c;
    }
}
