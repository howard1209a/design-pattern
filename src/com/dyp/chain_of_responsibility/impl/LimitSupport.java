package com.dyp.chain_of_responsibility.impl;

import com.dyp.chain_of_responsibility.Support;
import com.dyp.chain_of_responsibility.Trouble;

/**
 * @author howard
 * @version 1.0
 */
public class LimitSupport extends Support {
    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNum() < limit;
    }
}
