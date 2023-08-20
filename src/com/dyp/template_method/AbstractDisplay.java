package com.dyp.template_method;

/**
 * @author howard
 * @version 1.0
 */
public abstract class AbstractDisplay {
    abstract void open();

    abstract void print();

    abstract void close();

    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
