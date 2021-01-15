package juc.lock;

import java.util.concurrent.TimeUnit;


/**
 * 先发短信再打电话
 */
public class Test6 {

    public static void main(String[] args) {

        Phone6 p1 = new Phone6();
        Phone6 p2 = new Phone6();


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


class Phone6 {

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
