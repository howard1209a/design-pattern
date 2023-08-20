package com.dyp.proxy.impl;

import com.dyp.proxy.Printable;

/**
 * @Description: TODO
 */
public class Printer implements Printable {
    private String name;

    Printer() {
        heavyJob("Printer的实例生成中");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob("Printer的实例生成中");
    }

    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String s) {
        System.out.println("=== " + name + " ===");
        System.out.println(s);
    }

    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(".");
        }
        System.out.println("结束");
    }
}
