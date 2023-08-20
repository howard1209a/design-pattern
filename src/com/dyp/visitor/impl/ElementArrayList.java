package com.dyp.visitor.impl;

import com.dyp.visitor.Element;
import com.dyp.visitor.Entry;
import com.dyp.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author howard
 * @version 1.0
 */
public class ElementArrayList extends ArrayList<Element> implements Element {

    @Override
    public void accept(Visitor visitor) {
        for (int i = 0; i < size(); i++) {
            get(i).accept(visitor);
        }
    }
}
