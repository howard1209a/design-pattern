package com.dyp.prototype;

/**
 * @author howard
 * @version 1.0
 */
public class MessageBox implements Product, Cloneable {
    private char c;

    public MessageBox(char c) {
        this.c = c;
    }

    @Override
    public Product createCopy() throws CloneNotSupportedException {
        return (Product) clone();
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        for (int i = 0; i < length + 4; i++) {
            System.out.print(c);
        }
        System.out.println("");
        System.out.println(c + " " + s + " " + c);
        for (int i = 0; i < length + 4; i++) {
            System.out.print(c);
        }
        System.out.println("");
    }
}
