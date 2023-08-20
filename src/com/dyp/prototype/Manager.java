package com.dyp.prototype;

import java.util.HashMap;

/**
 * @author howard
 * @version 1.0
 */
public class Manager {
    private HashMap<String, Product> map = new HashMap<>();

    public void putPrototype(String name, Product product) {
        map.put(name, product);
    }

    public Product getInstance(String name) throws CloneNotSupportedException {
        Product product = map.get(name);
        if (product == null) {
            return null;
        }
        return product.createCopy();
    }
}
