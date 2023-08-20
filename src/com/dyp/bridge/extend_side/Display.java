package com.dyp.bridge.extend_side;

import com.dyp.bridge.impl_side.DisplayImpl;

/**
 * @author howard
 * @version 1.0
 */
public class Display {
    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    public void open() {
        impl.rawOpen();
    }

    public void print() {
        impl.rawPrint();
    }

    public void close() {
        impl.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }
}
