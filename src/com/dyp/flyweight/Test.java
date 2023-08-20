package com.dyp.flyweight;

/**
 * @Description: TODO
 */
public class Test {
    private static BigString[] bigStrings = new BigString[1000];

    public static void main(String[] args) {
        for (int i = 0; i < bigStrings.length; i++) {
            bigStrings[i] = new BigString("1209", true);
        }
        printUsedMemory();
        for (int i = 0; i < bigStrings.length; i++) {
            bigStrings[i] = new BigString("1209", false);
        }
        printUsedMemory();
    }

    private static void printUsedMemory() {
        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(usedMemory);
    }
}
