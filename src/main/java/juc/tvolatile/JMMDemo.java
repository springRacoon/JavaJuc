package juc.tvolatile;

import java.util.concurrent.TimeUnit;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-25 17:07
 */
public class JMMDemo {

    private static volatile int num = 0;

    public static void main(String[] args) {


        new Thread(()->{

            while (num==0){

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num =1;

        System.out.println(num);
    }
}
