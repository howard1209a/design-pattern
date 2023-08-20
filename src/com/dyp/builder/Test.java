package com.dyp.builder;

import com.dyp.builder.impl.Director;
import com.dyp.builder.impl.HTMLBuilder;
import com.dyp.builder.impl.TextBuilder;

import java.io.PrintWriter;

/**
 * @author howard
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {

        Director director1 = new Director(new TextBuilder());
        Director director2 = new Director(new HTMLBuilder());

        director1.construct();
        director2.construct();

        System.out.println(director1.getResult());
        System.out.println(director2.getResult());
    }
}
