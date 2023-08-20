package com.dyp.chain_of_responsibility.impl;

import com.dyp.chain_of_responsibility.Support;
import com.dyp.chain_of_responsibility.Trouble;

/**
 * @author howard
 * @version 1.0
 */
public class SpecialSupport extends Support {
    private int num;

    public SpecialSupport(String name, int num) {
        super(name);
        this.num = num;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNum() == num;
    }
}
