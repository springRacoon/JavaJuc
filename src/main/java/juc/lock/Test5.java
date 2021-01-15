package juc.lock;

import java.util.concurrent.TimeUnit;


/**
 * 先发短信再打电话
 */
public class Test5 {

    public static void main(String[] args) {

        Phone5 p1 = new Phone5();


        new Thread(() -> {
            p1.sendSms();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            p1.call();
        }, "B").start();
    }


}


class Phone5 {

    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call() {
        System.out.println("打电话");
    }

}
