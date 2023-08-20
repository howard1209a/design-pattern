package com.dyp.strategy.example2;

import com.dyp.strategy.example2.impl.BubbleSorter;
import com.dyp.strategy.example2.impl.SelectionSorter;

/**
 * @author howard
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String[] data = {
                "Dumpty","Bowman","Carroll","Elfland","Alice"
        };
        Sorter sorter1 = new SelectionSorter();
        Sorter sorter2 = new BubbleSorter();

        SortAndPrint sortAndPrint = new SortAndPrint(data,sorter2);
        sortAndPrint.execute();
    }
}
