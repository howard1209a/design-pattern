package com.dyp.strategy.example2.impl;

import com.dyp.strategy.example2.Sorter;

/**
 * @author howard
 * @version 1.0
 */
public class SelectionSorter implements Sorter {
    @Override
    public void sort(Comparable[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[minIndex].compareTo(data[j]) > 0) {
                    minIndex = j;
                }
            }
            Comparable<?> tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }
    }
}
