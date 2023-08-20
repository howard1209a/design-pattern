package com.dyp.abstract_factory.factory;

/**
 * @author howard
 * @version 1.0
 */
public abstract class Item {
    protected String caption;

    public Item(String caption) {
        this.caption = caption;
    }

    public abstract String makeHTML();
}
