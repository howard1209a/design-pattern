package com.dyp.visitor;

import com.dyp.visitor.impl.Directory;
import com.dyp.visitor.impl.ElementArrayList;
import com.dyp.visitor.impl.File;

/**
 * @author howard
 * @version 1.0
 */
public abstract class Visitor {
    public abstract void visit(File file);

    public abstract void visit(Directory directory);
}
