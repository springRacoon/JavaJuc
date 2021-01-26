package juc.single;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-26 14:20
 */
public class Hungry {



    private Hungry() {

    }

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance() {

        return HUNGRY;
    }
}
