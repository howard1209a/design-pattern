package com.dyp.decorator.impl;

import com.dyp.decorator.Display;

import java.util.ArrayList;
import java.util.List;

/**
 * @author howard
 * @version 1.0
 */
public class MultiStringDisplay extends Display {
    private List<String> list = new ArrayList<>();
    private int maxLength = 0;

    public void add(String s) {
        list.add(s);
        update(s.length());
    }

    @Override
    public int getColumns() {
        return maxLength;
    }

    @Override
    public int getRows() {
        return list.size();
    }

    @Override
    public String getRowText(int row) {
        return list.get(row);
    }

    private void update(int length) {
        if (length > maxLength) {
            maxLength = length;
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + spaces(maxLength - list.get(i).length()));
        }
    }

    private String spaces(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
