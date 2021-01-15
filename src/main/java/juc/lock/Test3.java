package juc.lock;

import java.util.concurrent.TimeUnit;


/**
 * 先hello 再发短信
 */
public class Test3 {

    public static void main(String[] args) {

        Phone3 p1 = new Phone3();

        new Thread(() -> {
            p1.sendSms();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            p1.hello();
        }, "B").start();
    }


}


class Phone3 {

    public synchronized void sendSms() {
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

    public void hello() {
        System.out.println("hello");
    }
}
