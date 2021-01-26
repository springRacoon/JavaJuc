package juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-26 15:52
 */
public class CASDemo {


    public static void main(String[] args) {

//        AtomicInteger atomicInteger = new AtomicInteger(2020);
//        atomicInteger.compareAndSet(2020,2021);
//        System.out.println(atomicInteger.get());

        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(111,1);

        new Thread(()->{
            System.out.println(atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(111,123,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(123,111,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(atomicStampedReference.getStamp());


            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"a").start();

        new Thread(()->{
            System.out.println(atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(111,123,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(atomicStampedReference.getStamp());

        },"b").start();

    }
}
