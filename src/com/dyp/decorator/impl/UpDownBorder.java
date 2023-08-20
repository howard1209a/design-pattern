package com.dyp.decorator.impl;

import com.dyp.decorator.Border;
import com.dyp.decorator.Display;

/**
 * @author howard
 * @version 1.0
 */
public class UpDownBorder extends Border {
    private char c;

    public UpDownBorder(Display display, char c) {
        super(display);
        this.c = c;
    }

    @Override
    public int getColumns() {
        return display.getColumns();
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return makeLine(c, getColumns());
        } else if (row == getRows() - 1) {
            return makeLine(c, getColumns());
        } else {
            return display.getRowText(row - 1);
        }
    }

    private String makeLine(char ch, int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
