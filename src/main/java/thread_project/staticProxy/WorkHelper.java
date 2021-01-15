package thread_project.staticProxy;

/**
 * @program: Juc
 * @description: 静态代理模式 真实对象和代理对象都要实现同一个接口
 * 代理对象可以对真实对象功能进行增强
 * @author: Saxon
 * @create: 2021-01-07 15:02
 */
public class WorkHelper implements Work {

    //代理真实目标
    private Work work;

    public WorkHelper(Work work) {
        this.work = work;
    }

    @Override
    public void doWork() {
        before();
        this.work.doWork();//真实对象
        after();
    }

    private void after() {
        System.out.println("完成工作");
    }

    private void before() {
        System.out.println("准备工作");
    }
}
