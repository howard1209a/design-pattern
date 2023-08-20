package com.dyp.abstract_factory.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author howard
 * @version 1.0
 */
public abstract class Page {
    protected String title;
    protected String author;
    protected List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void output() {
        String filename = "src/com/dyp/abstract_factory/" + title + ".html";
        try {
            Writer writer = new FileWriter(filename);
            writer.write(this.makeHTML());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract String makeHTML();
}
