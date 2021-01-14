package thread_project.thread;

/**
 * @program: Juc
 * @description: 线程休眠，模拟网络延迟，发现并发问题，不会释放锁
 * @author: Saxon
 * @create: 2021-01-07 15:42
 */
public class TestSleep implements Runnable {

    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "->拿到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();

        new Thread(testSleep,"小明").start();
        new Thread(testSleep,"小张").start();
        new Thread(testSleep,"小杨").start();

    }
}
