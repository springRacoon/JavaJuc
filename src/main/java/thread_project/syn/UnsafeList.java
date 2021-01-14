package thread_project.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Juc
 * @description: 线程不安全
 * @author: Saxon
 * @create: 2021-01-11 15:54
 */
public class UnsafeList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }

        System.out.println(list.size());
    }
}
