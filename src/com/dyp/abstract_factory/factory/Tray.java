package com.dyp.abstract_factory.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author howard
 * @version 1.0
 */
public abstract class Tray extends Item {
    protected List<Item> items = new ArrayList<>();

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        items.add(item);
    }
}
