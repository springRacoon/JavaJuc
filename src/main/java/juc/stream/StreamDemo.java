package juc.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-22 13:43
 */
public class StreamDemo {

    public static void main(String[] args) {

        User user = new User(1, "a", 21);
        User user2 = new User(2, "b", 22);
        User user3 = new User(3, "c", 23);
        User user4 = new User(4, "d", 24);
        User user5 = new User(6, "e", 25);

        List<User> users = Arrays.asList(user, user2, user3, user4, user5);

        users.stream().filter(u -> u.getId() % 2 == 0).filter(u -> u.getAge() > 23).map(u -> u.getName().toUpperCase()).sorted(Comparator.reverseOrder()).limit(1).forEach(System.out::println);


    }
}
