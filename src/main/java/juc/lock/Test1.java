package juc.lock;

import java.util.concurrent.TimeUnit;


/**
 * 先发短信，再打电话
 */
public class Test1 {

    public static void main(String[] args) {

        Phone1 p1 = new Phone1();

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


class Phone1 {

    public synchronized void sendSms() {
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }
}
