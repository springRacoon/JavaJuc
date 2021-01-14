package thread_project.thread;

/**
 * @program: Juc
 * @description: join插队
 * @author: Saxon
 * @create: 2021-01-08 15:47
 */
public class TestJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("join 线程 " + i);
        }
    }

    public static void main(String[] args) {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 500; i++) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main " + i);

        }
    }
}


