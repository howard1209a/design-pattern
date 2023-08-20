package com.dyp.builder.impl;

import com.dyp.builder.Builder;

/**
 * @author howard
 * @version 1.0
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("Greeting");
        builder.makeString("从上午到下午");
        builder.makeItems(new String[]{"早上好", "下午好"});
        builder.makeString("晚上");
        builder.makeItems(new String[]{"晚上好", "晚安", "再见"});
        builder.close();
    }

    public String getResult() {
        return builder.getResult();
    }
}
