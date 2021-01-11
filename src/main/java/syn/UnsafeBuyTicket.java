package syn;

import java.util.concurrent.TimeUnit;

/**
 * @program: Juc
 * @description: 不安全买票,会有负数
 * @author: Saxon
 * @create: 2021-01-11 15:31
 */
public class UnsafeBuyTicket {

    public static void main(String[] args) {

        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"one").start();
        new Thread(buyTicket,"two").start();
        new Thread(buyTicket,"three").start();

    }
}

class BuyTicket implements Runnable {
    private int ticketNums = 10;
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            canBuy();
        }

    }

    private void canBuy() {
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
    }
}
