package juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-18 10:33
 */
public class CallableTest {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(myThread);
        new Thread(integerFutureTask,"A").start();

        Integer integer = null;
        try {
            integer = integerFutureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(integer);

    }
}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("call()");
        return 1024;
    }
}
