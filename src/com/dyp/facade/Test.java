package com.dyp.facade;

/**
 * @author howard
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("hyuki@hyuki.com", "src/com/dyp/facade/welcome.html");
        PageMaker.makeLinkPage("src/com/dyp/facade/link.html");
    }
}
