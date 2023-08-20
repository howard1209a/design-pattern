package com.dyp.template_method;

import java.io.InputStream;

/**
 * @author howard
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        AbstractDisplay abstractDisplay1 = new CharDisplay('h');
        abstractDisplay1.display();
        AbstractDisplay abstractDisplay2 = new StringDisplay("hello, world");
        abstractDisplay2.display();
    }
}
