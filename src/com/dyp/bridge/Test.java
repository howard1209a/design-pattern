package com.dyp.bridge;

import com.dyp.bridge.extend_side.Display;
import com.dyp.bridge.extend_side.IncreaseDisplay;
import com.dyp.bridge.extend_side.RandomDisplay;
import com.dyp.bridge.impl_side.CharDisplayImpl;
import com.dyp.bridge.impl_side.FileDisplayImpl;
import com.dyp.bridge.impl_side.StringDisplayImpl;

/**
 * @author howard
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        RandomDisplay randomDisplay = new RandomDisplay(new StringDisplayImpl("hello,world"));
        randomDisplay.display();
        randomDisplay.multiDisplay(5);
        randomDisplay.randomDisplay();

        Display display = new Display(new FileDisplayImpl());
        display.display();

        IncreaseDisplay increaseDisplay = new IncreaseDisplay(new CharDisplayImpl('<', '*', '>'), 2);
        increaseDisplay.increaseDisplay(3);
    }
}
