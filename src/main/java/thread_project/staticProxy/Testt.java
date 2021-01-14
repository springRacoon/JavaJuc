package thread_project.staticProxy;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-13 08:58
 */
public class Testt {

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        set.remove(2);

        for (Integer integer : set) {
            System.out.println(integer);
        }

    }
}
