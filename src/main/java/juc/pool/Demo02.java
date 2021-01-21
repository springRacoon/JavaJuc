package juc.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-21 14:33
 */
public class Demo02 {

    public static void main(String[] args) {


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2
                , 5
                , 3
                , TimeUnit.SECONDS
                , new LinkedBlockingDeque<>(3)
                , Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.DiscardOldestPolicy());

        try {
            for (int i = 1; i <= 100; i++) {
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
