package thread_project.staticProxy;

/**
 * @program: Juc
 * @description: 静态代理模式
 * @author: Saxon
 * @create: 2021-01-07 14:59
 */
public class StaticProxy {

    public static void main(String[] args) {
        WorkHelper workHelper = new WorkHelper(new Worker());
        workHelper.doWork();
    }
}
