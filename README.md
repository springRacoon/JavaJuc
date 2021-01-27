## 线程五个状态

- 创建 NEW
- 就绪 WAITING TIMED_WAITING
- 阻塞 BLOCKED
- 运行 RUNNABLE
- 死亡 TERMINATED

## 线程的休眠、终止、礼让和插队

> 终止线程 建议使用终止变量 不建议使用stop或者destroy等方法
>
> 线程休眠 不会释放锁 可能会引发并发问题
>
> 线程礼让 让当前正在执行的线程暂停，但不阻塞，将线程从运行转为就绪 让cpu重新调度，但礼让不一定成功
>
> 线程插队 可以让该线程抢夺资源，先进行

## 静态代理模式

> 真实对象和代理对象都要实现同一个接口代理对象可以对真实对象功能进行增强

## 线程的优先级

> 先设置再启动，优先级低意味着获得调度的概率是不会被调用，还是看cpu额调度

## 线程分为用户线程和守护线程

> 用户线程(main、gc)
>
> 虚拟机必须确保用户线程执行完毕，不用等待守护线程执行完毕

## 关于锁，需要修改的内容才需要锁，锁的太多，浪费资源，影响性能

> 产生死锁的四个条件：
>
> 1.互斥条件:一个资源每次只能被一个进程使用
>
> 2.请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放
>
> 3.不剥夺条件: 进程已经获得的资源，在未使用完之前，不能强行剥夺
>
> 4.循环等待条件: 若干进程之间形成一种头尾相接的等待资源关系
>

## 可重入锁ReentrantLock

> 可以自己控制，注意规范注意加锁解锁。

---

## 并发问题的产生

> 多个线程同时操作同一个资源类
>
> synchronized的本质是队列，锁
>
> new ReentrantLock() -> lock.lock(); -> finally {lock.unlock();}

## 公平锁和非公平锁

> 公平锁不能插队
> 非公平锁可以插队（cpu）判断

## synchronized和lock的区别

> synchronized 是内置关键字；lock 是一个类
>
> synchronized 无法判断锁的状态；lock 可以判断是否获取到了锁
>
> synchronized 回自动释放锁；lock 必须手动释放锁，如果不释放，会死锁
>
> synchronized 线程1获得锁，线程2会等待；lock 锁不一定会等待（lock.tryLock()）
>
> synchronized 可重入锁，不可以中断，非公平；lock 可重入锁，可以判断锁，非公平（可设置）
>
> synchronized 适合少量的代码同步部分问题；lock 适合大量的代码同步问题

## 虚假唤醒

> 线程也可以唤醒，而不会被通知，就是所谓的虚假唤醒，虽然很少发生，但是应该注意。应该在判断等待时使用while而不是if

## Condition的优势

> 精准的通知和唤醒线程

## synchronized

> synchronized锁的对象是方法的调用者
>
> static 静态方法 类一加载就有了 锁的是Class
>
> 主要看锁的是谁，用的是不是一把锁

## java.util.ConcurrentModificationException

> 并发修改异常，使用线程不安全的类有可能会出现该错误

---

## List

> ArrayList 线程不安全,解决方法：
>
> 1.Vector
>
> 2.Collections.synchronizedList(new ArrayList<>());
>
> 3.new CopyOnWriteArrayList<>();(写入时复制， COW 计算机程序设计领域的一种优化策略。多线程调用时，读取的时候是固定的，写入可能会覆盖。避免写入时覆盖，造成数据问题)
>
> PS:Vector比CopyOnWriteArrayList出在哪里
>
> Vector使用了synchronized，效率低\

## HashSet

> HashSet 线程不安全,解决方法：
>
> 1.Vector
>
> 2.Collections.synchronizedSet(new HashSet<>());
>
> 3.new CopyOnWriteArraySet<>();
>
> PS:HashSet的底层是HashMap

## HashMap

> HashMap 线程不安全,解决方法：
>
> 1.Collections.synchronizedMap(new HashMap<>())
>
> 2.new ConcurrentHashMap();

# callalbe

> MyThread myThread = new MyThread();
>
> FutureTask<Integer> integerFutureTask = new FutureTask<>(myThread);
>
> new Thread(integerFutureTask,"A").start();
>
> 可以获取结束后的值

## CountDownLatchDemo

> 计数器，可以等待归零后再操作，每次countDown()-1，变为0后，唤醒计数器，await被唤醒，继续执行

## CyclicBarrier

> 加法计数器 线程相互等待，当所有线程都到达某个屏障点后再进行后续的操作。

## Semaphore

> 可以用来控制同时访问特定资源的线程数量，通过协调各个线程，以保证合理地使用资源
> semaphore.acquire() 获得，假设已经满了，等待，等待被释放为止
> semaphore.release() 释放，会将当前信号量释放+1，然后唤醒等待的线程

## ReadWriteLock

> 读可以多个线程读取，写只能一个一个线程写
>
> 读和读可以共存，读和写、写和写不能共存
>
> （独占锁，共享锁）：独占锁（写锁），一次只能被一个线程占有，共享锁（读锁），多个线程可以同时占有

## BlockingQueue

> 什么情况下使用？：多线程并发处理，线程池

|  方式   | 抛出异常 | 有返回值  | 阻塞 等待  | 超时等待  |
|  :----:  | :----:     | :----: | :----:  | :----: |
| 添加    |   add()  |   offer()   |   put()    |   put()  |
| 移除    |   remove()  |   poll()  |   take()   |  take() |
| 判断队首尾 |   element()  |   peek()  |   -   |  -  |


## SynchronousQueue
> 阻塞队列，只能写入一个，拿出后才能再写入


## 线程池
> 程序运行的本质：占用系统的资源！优化资源的使用=>池化技术
> 
> 池化技术：事先准备好一些资源，有人要用，就来这里拿，用完之后还回来
> 
> 线程吃的好处：
> 
> 1.降低资源的消耗
> 
> 2.提高响应的速度
> 
> 3.方便管理，可以控制最大并发数，管理线程
> 
> *三大方法，七大参数，四种拒绝策略

```java
        //单个线程
        Executors.newSingleThreadExecutor();

        //创建一个固定的线程池的大小
        Executors.newFixedThreadPool(5);

        //创建一个固定的线程池的大小（可自动调节）
        Executors.newCachedThreadPool();
```
> *七大参数
> 
> 1.corePoolSize 核心线程池大小
> 
> 2.maximumPoolSize 最大核心线程池大小
> 
> 3.keepAliveTime 超时没有人调用就会释放
> 
> 4.unit 超时单位
> 
> 5.workQueue 阻塞队列
> 
> 6.threadFactory 线程工厂，用来创建线程
> 
> 7.handle 拒绝策略

>*四种拒绝策略
> 
> AbortPolicy 不处理，抛出异常
> 
> CallerRunsPolicy 哪个线程来的，哪个线程执行
> 
> DiscardPolicy 不会抛出异常，不会处理
> 
> DiscardOldestPolicy 抛弃队列里最老的，代替他的位置进入队列 不会抛出异常


## 最大线程数如何定义
>1.CPU密集型 几核CPU就定义为几，可以保证CPU效率最高 
> 
> Runtime.getRuntime().availableProcessors()
> 
>2.IO密集型  可以设置为判断你的程序中最消耗IO的线程数


##函数式接口
>只有一个方法的接口
> 
>四大函数式接口：Consumer,Function,Predicate,Supplier
> 
> 1.Function 一个输入参数，一个输出参数 
> 
> 2.Predicate 一个输入参数，返回值只能是boolean 
> 
> 3.Consumer 只有输入 没有返回值
> 
> 4.Supplier 只有返回值 没有输入


## 异步回调
> CompletableFuture<T>
> 
> supplyAsync （有返回值）
> 
> runAsync （无返回值）


## JMM(Java内存模型)
> Volatile 是Java虚拟机提供轻量级的同步机制
> 
> 1、保证可见性
> 
> 2、不保证原子性
> 
> 3、禁止指令重排

## 关于JMM的同步约定
> 线程解锁前，必须把共享变量立刻刷回主存
> 
> 线程加锁前，必须读取主存中最新值到工作内存中
> 
> 加锁和解锁是同一把锁


## 如果不加lock和synchronized 怎么保证原子性
> Atomic 原子类


## Volatile内存屏障在什么地方使用最多
> 单例模式

## 单例模式
> 1.饿汉式
> 
> 2.懒汉式
> 
> 3.内部类
> 
> 4.枚举


## CAS
> 比较当前工作内存中的值和主内存中的值，如果这个值是期望的，那么执行操作!如果不是就一直循环!（自旋锁）
> 缺点 1.循环会耗时 2.一次只能保证一个共享变量的原子性 3.ABA问题

## 各种锁的理解
> 1、公平锁和非公平锁
> 
> 公平锁：不能插队，先来先到；非公平锁：可以插队
> 
> 2、可重入锁（递归锁）
> 
> 3、自旋锁
> 
> 4、死锁
> 
> jps命令查看线程信息