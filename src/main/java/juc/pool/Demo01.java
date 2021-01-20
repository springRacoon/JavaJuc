package juc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-20 14:06
 */
public class Demo01 {

    public static void main(String[] args) {


        //单个线程
        Executors.newSingleThreadExecutor();

        //创建一个固定的线程池的大小
        Executors.newFixedThreadPool(5);

        //创建一个固定的线程池的大小（可自动调节）
        Executors.newCachedThreadPool();
    }
}
