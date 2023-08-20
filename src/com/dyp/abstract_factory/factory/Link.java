package com.dyp.abstract_factory.factory;

/**
 * @author howard
 * @version 1.0
 */
public abstract class Link extends Item {
    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
