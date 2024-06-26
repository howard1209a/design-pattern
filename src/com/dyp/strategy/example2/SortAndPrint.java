package com.dyp.strategy.example2;

/**
 * @author howard
 * @version 1.0
 */
public class SortAndPrint {
    private Comparable[] data;
    private Sorter sorter;

    public SortAndPrint(Comparable[] data, Sorter sorter) {
        this.data = data;
        this.sorter = sorter;
    }

    public void execute() {
        print();
        sorter.sort(data);
        print();
    }

    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println("");
    }
}
