package juc.add;

import java.util.concurrent.CountDownLatch;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-18 11:11
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {

        //倒计时
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()+"go out");
            },String.valueOf(i+1)).start();
        }

        try {
            //等待归零
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("close");
    }
}
