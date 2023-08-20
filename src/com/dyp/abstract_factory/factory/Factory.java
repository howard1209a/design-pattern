package com.dyp.abstract_factory.factory;

/**
 * @author howard
 * @version 1.0
 */
public abstract class Factory {
    public static Factory getFactory(String classname) {
        Factory factory = null;
        Class c = null;
        try {
            c = Class.forName(classname);
            factory = (Factory) c.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return factory;
    }

    public abstract Link createLink(String caption, String url);

    public abstract Tray createTray(String caption);

    public abstract Page createPage(String title,String author);
}
