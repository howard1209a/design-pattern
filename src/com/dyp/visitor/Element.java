package com.dyp.visitor;

public interface Element {
    void accept(Visitor visitor);
}
