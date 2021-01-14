package thread_project.thread;

/**
 * @program: Juc
 * @description: 守护线程
 * @author: Saxon
 * @create: 2021-01-11 14:37
 */
public class TestDaemon {


    public static void main(String[] args) {
        Foo foo = new Foo();
        Bar bar = new Bar();

        Thread thread = new Thread(foo);
        thread.setDaemon(true);//守护线程
        thread.start();
        new Thread(bar).start();
    }

}

class Foo implements  Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("foo");
        }
    }
}


class Bar implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("bar");
        }

        System.out.println("die");
    }
}
