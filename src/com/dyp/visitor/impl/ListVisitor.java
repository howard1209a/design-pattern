package com.dyp.visitor.impl;

import com.dyp.visitor.Entry;
import com.dyp.visitor.Visitor;

import java.util.Iterator;

/**
 * @author howard
 * @version 1.0
 */
public class ListVisitor extends Visitor {
    private String currentPath = "";

    @Override
    public void visit(File file) {
        System.out.println(currentPath + "/" + file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currentPath + "/" + directory);
        String tmp = currentPath;
        currentPath = currentPath + "/" + directory.getName();
        Iterator<Entry> iterator = directory.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            entry.accept(this);
        }
        currentPath = tmp;
    }
}
