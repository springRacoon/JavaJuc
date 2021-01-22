package juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-22 14:12
 */
public class Test {

    public static void main(String[] args) {

            test3();

    }


    public static void test1() {

        long start = System.currentTimeMillis();

        Long sum = 0L;
        for (int i = 0; i < 10_0000_0000; i++) {
            sum += i;
        }

        long end = System.currentTimeMillis();

        System.out.println("sum=" + sum + "时间" + (end - start));


    }

    public static void test2() throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);

        Long aLong = submit.get();

        long end = System.currentTimeMillis();

        System.out.println("sum=" + aLong + "时间" + (end - start));


    }

    public static void test3() {

        long start = System.currentTimeMillis();

        long reduce = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);

        long end = System.currentTimeMillis();

        System.out.println("sum="+reduce+"时间"+(end-start));


    }
}
