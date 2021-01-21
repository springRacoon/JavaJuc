package juc.function;

import java.util.function.Predicate;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-21 16:39
 */
public class PredicateDemo {

    public static void main(String[] args) {
        Predicate predicate = new Predicate<String>(){
            @Override
            public boolean test(String s) {

                return s.isEmpty();
            }
        };


        System.out.println(predicate.test("123"));

    }

}
