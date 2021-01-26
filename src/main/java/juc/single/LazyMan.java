package juc.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-26 14:22
 */
public class LazyMan {

    private static boolean flag = false;

    private LazyMan() {
        if(!flag){
            flag=true;
        }else{
            throw new RuntimeException("不要使用反射破坏");
        }
        System.out.println("ok");
    }

    private volatile static LazyMan lazyMan;

    //双重检测锁
    public static LazyMan getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

//        LazyMan instance = LazyMan.getInstance();
        Field flag = LazyMan.class.getDeclaredField("flag");
        flag.setAccessible(true);
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        LazyMan instance1 = declaredConstructor.newInstance();
        flag.set(instance1,false);
        LazyMan instance2 = declaredConstructor.newInstance();


    }
}
