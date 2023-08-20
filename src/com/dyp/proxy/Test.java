package com.dyp.proxy;

import com.dyp.proxy.impl.PrinterProxy;

/**
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        Printable printable = new PrinterProxy("Alice","com.dyp.proxy.impl.Printer");
        System.out.println("现在的名字是 "+printable.getPrinterName());
        printable.setPrinterName("Bob");
        System.out.println("现在的名字是 "+printable.getPrinterName());
        printable.print("Hello,world");
    }
}
