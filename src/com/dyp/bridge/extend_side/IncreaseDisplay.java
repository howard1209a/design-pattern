package com.dyp.bridge.extend_side;

import com.dyp.bridge.impl_side.DisplayImpl;

/**
 * @author howard
 * @version 1.0
 */
public class IncreaseDisplay extends CountDisplay {
    private int step;

    public IncreaseDisplay(DisplayImpl impl, int step) {
        super(impl);
        this.step = step;
    }

    public void increaseDisplay(int level) {
        int count = 1;
        for (int i = 0; i < level; i++) {
            multiDisplay(count);
            count += step;
        }
    }
}
