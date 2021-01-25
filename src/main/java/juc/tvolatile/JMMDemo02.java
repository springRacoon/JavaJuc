package juc.tvolatile;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-25 17:07
 */
public class JMMDemo02 {

//    private static int num = 0;

    private static AtomicInteger num = new AtomicInteger(0);

    public static void add(){
        num.getAndIncrement();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {

            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    add();
                }
            }).start();
        }

        while(Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+" "+num);
    }
}
