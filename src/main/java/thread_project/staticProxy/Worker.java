package thread_project.staticProxy;

/**
 * @program: Juc
 * @description: 静态代理模式
 * @author: Saxon
 * @create: 2021-01-07 15:01
 */
public class Worker implements Work{
    @Override
    public void doWork() {
        System.out.println("doing work");
    }
}
