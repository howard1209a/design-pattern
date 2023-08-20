package com.dyp.bridge.extend_side;

import com.dyp.bridge.extend_side.Display;
import com.dyp.bridge.impl_side.DisplayImpl;

/**
 * @author howard
 * @version 1.0
 */
public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
