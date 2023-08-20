package com.dyp.decorator.impl;

import com.dyp.decorator.Display;

/**
 * @author howard
 * @version 1.0
 */
public class StringDisplay extends Display {
    private String s;

    public StringDisplay(String s) {
        this.s = s;
    }

    @Override
    public int getColumns() {
        return s.getBytes().length;
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int row) {
        return s;
    }
}
