package juc.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-14 14:18
 */
public class SaleTicketDemo02 {

    public static void main(String[] args) {

        Ticket2 ticket = new Ticket2();

        new Thread(() -> { for (int i = 0; i < 60; i++) {
            ticket.sale();
        }
        }, "A").start();
        new Thread(() -> { for (int i = 0; i < 60; i++) {
            ticket.sale();
        }
        }, "B").start();
        new Thread(() -> { for (int i = 0; i < 60; i++) {
            ticket.sale();
        }
        }, "C").start();
    }

}

class Ticket2 {
    private int number = 50;

    Lock lock = new ReentrantLock();

    public void sale() {

        try {
            lock.lock();
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第" + number-- + "张票,剩余" + number);
            }

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
