package com.dyp.bridge.extend_side;

import com.dyp.bridge.extend_side.CountDisplay;
import com.dyp.bridge.impl_side.DisplayImpl;

import java.util.Random;

/**
 * @author howard
 * @version 1.0
 */
public class RandomDisplay extends CountDisplay {
    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay() {
        open();
        for (int i = 0; i < new Random().nextInt(8); i++) {
            print();
        }
        close();
    }
}
