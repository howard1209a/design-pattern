package com.dyp.chain_of_responsibility.impl;

import com.dyp.chain_of_responsibility.Support;
import com.dyp.chain_of_responsibility.Trouble;

/**
 * @author howard
 * @version 1.0
 */
public class OddSupport extends Support {

    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNum() % 2 == 1;
    }
}
