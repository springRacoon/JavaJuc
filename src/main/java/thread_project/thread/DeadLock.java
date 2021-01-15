package thread_project.thread;

/**
 * @program: Juc
 * @description: 死锁
 * @author: Saxon
 * @create: 2021-01-12 10:50
 */
public class DeadLock {

    public static void main(String[] args) {

        Do do1 = new Do(0, "张三");
        Do do2 = new Do(1, "李四");
        do1.start();
        do2.start();

    }
}

class One {

}

class Two {

}

class Do extends Thread {

    static One one = new One();
    static Two two = new Two();

    int choice;
    String girlName;

    Do(int choice, String name) {
        this.choice = choice;
        this.girlName = name;
    }

    @Override
    public void run() {
        makeup();
    }

    private void makeup() {
        if (choice == 0) {
            synchronized (one) {
                System.out.println(this.choice + "获得锁one");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (two) {
                    System.out.println(this.choice + "获得锁two");
                }
            }
        } else {
            synchronized (two) {
                System.out.println(this.choice + "获得锁two");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (one) {
                    System.out.println(this.choice + "获得锁one");
                }
            }
        }
    }
}
