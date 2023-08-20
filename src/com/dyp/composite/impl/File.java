package com.dyp.composite.impl;

import com.dyp.composite.Entry;

/**
 * @author howard
 * @version 1.0
 */
public class File extends Entry {
    private String name;
    private int size;
    private Entry parent;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Entry getParent() {
        return parent;
    }

    public void setParent(Entry parent) {
        this.parent = parent;
    }

    @Override
    public void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }

    @Override
    public void printPath() {
        System.out.println("");
        if (parent == null) {
            System.out.print("/" + name);
        } else {
            parent.printPath();
            System.out.print("/" + name);
        }
    }
}
