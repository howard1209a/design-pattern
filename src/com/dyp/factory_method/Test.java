package com.dyp.factory_method;

import com.dyp.factory_method.framework.Factory;
import com.dyp.factory_method.framework.Product;
import com.dyp.factory_method.idcard.IDCardFactory;

/**
 * @author howard
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product idCard1 = factory.create("john");
        Product idCard2 = factory.create("mike");
        Product idCard3 = factory.create("lucy");
        System.out.println(((IDCardFactory) factory).getOwnerList());
        idCard1.use();
        idCard2.use();
        idCard3.use();
    }
}
