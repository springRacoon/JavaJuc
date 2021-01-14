package thread_project.thread;

/**
 * @program: Juc
 * @description: 礼让不一定成功
 * @author: Saxon
 * @create: 2021-01-07 16:07
 */
public class TestYield {
    public static void main(String[] args) {

        MyYield myYield = new MyYield();
        new Thread(myYield,"a ").start();
        new Thread(myYield,"b ").start();
    }

}


class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "run");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "stop");
    }
}