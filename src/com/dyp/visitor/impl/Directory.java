package com.dyp.visitor.impl;

import com.dyp.visitor.Entry;
import com.dyp.visitor.Visitor;

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
    public Entry add(Entry entry) {
        list.add(entry);
        return this;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Iterator<Entry> iterator() {
        return list.iterator();
    }
}
