package com.dyp.visitor.impl;

import com.dyp.visitor.Entry;
import com.dyp.visitor.Visitor;

import java.util.Iterator;

/**
 * @author howard
 * @version 1.0
 */
public class SizeVisitor extends Visitor {
    private int size = 0;

    @Override
    public void visit(File file) {
        size += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        Iterator<Entry> iterator = directory.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(this);
        }
    }

    public int getSize() {
        int tmp = size;
        size = 0;
        return tmp;
    }
}
