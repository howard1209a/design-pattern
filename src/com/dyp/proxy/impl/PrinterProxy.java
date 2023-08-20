package com.dyp.proxy.impl;

import com.dyp.proxy.Printable;

/**
 * @Description: TODO
 */
public class PrinterProxy implements Printable {
    private String name;
    private Printable printer;
    private String className;

    public PrinterProxy() {
    }

    public PrinterProxy(String name, String className) {
        this.name = name;
        this.className = className;
    }

    // 先修改printer的name，再修改自己的name，就需要考虑多线程的数据一致性问题，因为前后两次修改之间可能会插入其他操作
    @Override
    public synchronized void setPrinterName(String name) {
        if (printer != null) {
            printer.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String s) {
        realize();
        printer.print(s);
    }

    private synchronized void realize() {
        if (printer == null) {
            try {
                printer = (Printable) Class.forName(className).newInstance();
                printer.setPrinterName(name);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
