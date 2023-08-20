package com.dyp.prototype;

/**
 * @author howard
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Manager manager = new Manager();
        manager.putPrototype("underlinePen",new UnderlinePen('-'));
        manager.putPrototype("messageBox",new MessageBox('*'));
        manager.getInstance("underlinePen").use("hello, world");
        manager.getInstance("messageBox").use("hello, world");
    }
}
