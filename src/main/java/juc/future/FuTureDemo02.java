package juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-25 14:57
 */
public class FuTureDemo02 {

    public static void main(String[] args) {

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"Integer");
//            int i = 10/0;
            return 1024;
        });

        try {
            System.out.println(completableFuture.whenComplete((t, u) -> {
                System.out.println("t " + t);
                System.out.println("u " + u);
            }).exceptionally((e) -> {
                e.printStackTrace();
                return 233;
            }).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
