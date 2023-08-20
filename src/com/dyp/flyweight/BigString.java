package com.dyp.flyweight;

/**
 * @Description: TODO
 */
public class BigString {
    private BigChar[] bigChars;

    public BigString(String s, boolean shared) {
        bigChars = new BigChar[s.length()];
        if (shared) {
            BigCharFactory bigCharFactory = BigCharFactory.getInstance();
            for (int i = 0; i < s.length(); i++) {
                bigChars[i] = bigCharFactory.getBigChar(s.charAt(i));
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                bigChars[i] = new BigChar(s.charAt(i));
            }
        }
    }

    public void print() {
        for (BigChar bigChar : bigChars) {
            bigChar.print();
        }
    }
}
