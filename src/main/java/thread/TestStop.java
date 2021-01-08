package thread;

/**
 * @program: Juc
 * @description: 终止线程。建议使用终止变量。不建议使用stop或者destroy等方法
 * @author: Saxon
 * @create: 2021-01-07 15:24
 */
public class TestStop implements Runnable {

    //设置标识位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run...Thread" + i++);
        }
    }

    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main " + i);
            if (i == 900) {
                testStop.stop();
                System.out.println("has stopped");
            }
        }
    }
}
