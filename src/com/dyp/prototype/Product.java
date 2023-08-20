package com.dyp.prototype;

public interface Product {
    Product createCopy() throws CloneNotSupportedException;
    void use(String s);
}
