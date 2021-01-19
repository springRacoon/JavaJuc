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


#callalbe
>  MyThread myThread = new MyThread();
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