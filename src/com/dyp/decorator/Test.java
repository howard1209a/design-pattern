package com.dyp.decorator;

import com.dyp.decorator.impl.*;

/**
 * @author howard
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("hello,world");
        Display b2 = new SideBorder(b1, '#');
        Display b3 = new FullBorder(b2);
        b1.show();
        b2.show();
        b3.show();

        Display b4 =
                new SideBorder(
                        new FullBorder(
                                new FullBorder(
                                        new SideBorder(
                                                new FullBorder(
                                                        new StringDisplay("hello,world")
                                                ),
                                                '*'
                                        )
                                )
                        ),
                        '/'
                );
        b4.show();

        Display b5 = new UpDownBorder(b1, '$');
        b5.show();

        MultiStringDisplay md = new MultiStringDisplay();
        md.add("good morning");
        md.add("good afternoon");
        md.add("good night,see you tommorrow");
        Display b6 = new FullBorder(md);
        b6.show();
    }
}
