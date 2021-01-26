package juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-26 15:52
 */
public class CASDemo {


    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(2020);
        atomicInteger.compareAndSet(2020,2021);
        System.out.println(atomicInteger.get());
    }
}
