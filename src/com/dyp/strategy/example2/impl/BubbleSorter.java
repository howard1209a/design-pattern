package com.dyp.strategy.example2.impl;

import com.dyp.strategy.example2.Sorter;

/**
 * @author howard
 * @version 1.0
 */
public class BubbleSorter implements Sorter {
    @Override
    public void sort(Comparable[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 1; j < data.length - i; j++) {
                if (data[j - 1].compareTo(data[j]) > 0) {
                    Comparable tmp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = tmp;
                }
            }
        }
    }
}
