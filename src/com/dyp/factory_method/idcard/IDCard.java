package com.dyp.factory_method.idcard;

import com.dyp.factory_method.framework.Product;

/**
 * @author howard
 * @version 1.0
 */
public class IDCard extends Product {
    private String owner;

    IDCard(String owner) {
        System.out.println("制作" + owner + "的IDCard");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "的IDCard");
    }

    public String getOwner() {
        return owner;
    }
}
