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
public class FileFindVisitor extends Visitor {
    private List<File> list = new ArrayList<>();

    @Override
    public void visit(File file) {
        if (file.getName().contains(".") && "html".equals(file.getName().split("\\.")[1])) {
            list.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        Iterator<Entry> iterator = directory.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            entry.accept(this);
        }
    }

    public Iterator<File> getFoundFiles() {
        return list.iterator();
    }
}
