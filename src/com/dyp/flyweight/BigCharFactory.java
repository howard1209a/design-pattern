package com.dyp.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 */
public class BigCharFactory {
    private Map<Character, BigChar> pool = new HashMap<>();
    private static final BigCharFactory BIG_CHAR_FACTORY = new BigCharFactory();

    private BigCharFactory() {
    }

    public static BigCharFactory getInstance() {
        return BIG_CHAR_FACTORY;
    }

    public synchronized BigChar getBigChar(char charname) {
        BigChar bigChar = pool.get(charname);
        if (bigChar == null) {
            bigChar = new BigChar(charname);
            pool.put(charname, bigChar);
        }
        return bigChar;
    }
}
