package juc.lock;

import java.util.concurrent.TimeUnit;


/**
 * 先打电话再发短信
 */
public class Test7 {

    public static void main(String[] args) {

        Phone7 p1 = new Phone7();


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


class Phone7 {

    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public  synchronized void call() {
        System.out.println("打电话");
    }

}
