package com.dyp.builder.impl;

import com.dyp.builder.Builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author howard
 * @version 1.0
 */
public class HTMLBuilder extends Builder {
    private String filename;
    private PrintWriter printWriter;

    @Override
    public void buildTitle(String title) {
        filename = "src/com/dyp/builder/" + title + ".html";
        try {
            printWriter = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        printWriter.println("<html><head>" + "<meta charset=\"UTF-8\">" + "<title>" + title + "</title></head><body>");
        printWriter.println("<h1>" + title + "</h1>");
    }

    @Override
    public void buildString(String str) {
        printWriter.println("<p>" + str + "</p>");
    }

    @Override
    public void buildItems(String[] items) {
        printWriter.println("<ul>");
        for (int i = 0; i < items.length; i++) {
            printWriter.println("<li>" + items[i] + "</li>");
        }
        printWriter.println("</ul>");
    }

    @Override
    public void buildClose() {
        printWriter.println("</body></html>");
        printWriter.close();
    }

    public String buildGetResult() {
        return filename;
    }
}
