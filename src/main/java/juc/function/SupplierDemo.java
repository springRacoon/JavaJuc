package juc.function;

import java.util.function.Supplier;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-21 17:08
 */
public class SupplierDemo {

    public static void main(String[] args) {

        Supplier supplier = new  <String>() {
            @Override
            public String get() {
                return "123";
            }
        };

        System.out.println(supplier.get());
    }

}
