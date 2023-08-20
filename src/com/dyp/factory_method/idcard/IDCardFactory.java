package com.dyp.factory_method.idcard;

import com.dyp.factory_method.framework.Factory;
import com.dyp.factory_method.framework.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author howard
 * @version 1.0
 */
public class IDCardFactory extends Factory {
    private List<String> ownerList = new ArrayList<>();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        ownerList.add(((IDCard)product).getOwner());
    }

    public List<String> getOwnerList() {
        return ownerList;
    }
}
