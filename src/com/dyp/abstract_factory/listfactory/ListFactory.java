package com.dyp.abstract_factory.listfactory;

import com.dyp.abstract_factory.factory.Factory;
import com.dyp.abstract_factory.factory.Link;
import com.dyp.abstract_factory.factory.Page;
import com.dyp.abstract_factory.factory.Tray;

/**
 * @author howard
 * @version 1.0
 */
public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
