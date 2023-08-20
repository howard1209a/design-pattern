package com.dyp.factory_method.framework;

/**
 * @author howard
 * @version 1.0
 */
public abstract class Factory {
    public Product create(String owner) {
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }

    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);
}
