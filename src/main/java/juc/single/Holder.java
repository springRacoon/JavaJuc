package juc.single;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-26 15:33
 */
public class Holder {

    private Holder() {

    }

    public static Holder getInstance() {
        return InnerClass.HOLDER;
    }

    public static class InnerClass {
        private static final Holder HOLDER = new Holder();
    }
}
