package com.dyp.composite.impl;

import com.dyp.composite.Entry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author howard
 * @version 1.0
 */
public class Directory extends Entry {
    private String name;
    private List<Entry> list = new ArrayList<>();
    private Entry parent;

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getSize();
        }
        return sum;
    }

    @Override
    public Entry getParent() {
        return parent;
    }

    public void setParent(Entry parent) {
        this.parent = parent;
    }

    @Override
    public Entry add(Entry entry) {
        entry.setParent(this);
        list.add(entry);
        return this;
    }

    @Override
    public void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator<Entry> iterator = list.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            entry.printList(prefix + "/" + name);
        }
    }

    @Override
    public void printPath() {
        if (parent == null) {
            System.out.print("/" + name);
        } else {
            parent.printPath();
            System.out.print("/" + name);
        }
    }
}
