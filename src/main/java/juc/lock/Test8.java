package juc.lock;

import java.util.concurrent.TimeUnit;


/**
 * 先打电话再发短信
 */
public class Test8 {

    public static void main(String[] args) {

        Phone8 p1 = new Phone8();
        Phone8 p2 = new Phone8();


        new Thread(() -> {
            p1.sendSms();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            p2.call();
        }, "B").start();
    }


}


class Phone8 {

    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }

}
