package com.dyp.builder.impl;

import com.dyp.builder.Builder;

/**
 * @author howard
 * @version 1.0
 */
public class TextBuilder extends Builder {
    StringBuffer stringBuffer = new StringBuffer();

    @Override
    public void buildTitle(String title) {
        stringBuffer.append("=============================\n");
        stringBuffer.append("[" + title + "]\n");
        stringBuffer.append("\n");
    }

    @Override
    public void buildString(String str) {
        stringBuffer.append("*" + str + "\n");
        stringBuffer.append("\n");
    }

    @Override
    public void buildItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            stringBuffer.append(" > " + items[i] + "\n");
        }
        stringBuffer.append("\n");
    }

    @Override
    public void buildClose() {
        stringBuffer.append("=============================\n");
    }

    public String buildGetResult() {
        return stringBuffer.toString();
    }
}
