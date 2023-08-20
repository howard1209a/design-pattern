package com.dyp.decorator;

/**
 * @author howard
 * @version 1.0
 */
public abstract class Border extends Display {
    protected Display display;

    protected Border(Display display) {
        this.display = display;
    }
}
