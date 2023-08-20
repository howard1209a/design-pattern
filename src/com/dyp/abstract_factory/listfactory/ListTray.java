package com.dyp.abstract_factory.listfactory;

import com.dyp.abstract_factory.factory.Item;
import com.dyp.abstract_factory.factory.Tray;

/**
 * @author howard
 * @version 1.0
 */
public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer sb = new StringBuffer();
        sb.append("<li>\n");
        sb.append(caption + "\n");
        sb.append("<ul>\n");
        for (Item item : items) {
            sb.append(item.makeHTML());
        }
        sb.append("</ul>\n");
        sb.append("</li>\n");
        return sb.toString();
    }
}
