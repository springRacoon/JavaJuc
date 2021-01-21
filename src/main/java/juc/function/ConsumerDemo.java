package juc.function;

import java.util.function.Consumer;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-21 17:02
 */
public class ConsumerDemo {

    public static void main(String[] args) {


        Consumer consumer = new Consumer<String>() {

            @Override
            public void accept(String o) {

                System.out.println(o);
            }
        };


        consumer.accept("123") ;
    }
}
