package com.dyp.singleton;

/**
 * @author howard
 * @version 1.0
 */
public class Triple {
    private static final Triple[] triples = new Triple[3];

    private Triple() {
    }

    // 这里采用懒汉式，因此需要用synchronized在类上上锁保证多线程安全
    public static synchronized Triple getInstance(int id) {
        if (triples[id - 1] == null) {
            triples[id - 1] = new Triple();
        }
        return triples[id - 1];
    }
}
