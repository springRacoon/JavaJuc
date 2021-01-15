package juc.unsafe;

import java.util.HashMap;
import java.util.UUID;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-15 15:06
 */
public class MapTest {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();

//        Collections.synchronizedMap(new HashMap<>());


        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }, String.valueOf(i + 1)).start();
        }

    }
}
