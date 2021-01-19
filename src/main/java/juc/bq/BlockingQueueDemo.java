package juc.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-19 16:40
 */
public class BlockingQueueDemo {

    public static void main(String[] args)  {

        test4();
    }


    public static void test1(){
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));
        System.out.println(arrayBlockingQueue.element());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.add("d"));

    }

    public static void test2(){
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.peek());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
    }

    public static void test3() {

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        try {
            arrayBlockingQueue.put("a");
            arrayBlockingQueue.put("b");
            arrayBlockingQueue.put("c");
            System.out.println(arrayBlockingQueue.take());
            System.out.println(arrayBlockingQueue.take());
            System.out.println(arrayBlockingQueue.take());
            System.out.println(arrayBlockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void test4(){
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));
        try {
            System.out.println(arrayBlockingQueue.offer("d",2, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
    }
}
