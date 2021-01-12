package thread;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-12 14:22
 */
public class TestReentrantLock {

    public static void main(String[] args) {
        TestReentrantLock2 test = new TestReentrantLock2();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();

    }
}


class TestReentrantLock2 implements Runnable{
    int ticketNums = 10;

    private final ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        while (true){
            try{
                lock.lock();
                if(ticketNums >0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else{
                    break;
                }
            }
            finally {
                lock.unlock();
            }

        }
    }
}
