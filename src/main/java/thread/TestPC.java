package thread;

/**
 * @program: Juc
 * @description: 生产者消费者模型
 * @author: Saxon
 * @create: 2021-01-12 15:00
 */
public class TestPC {

    public static void main(String[] args) {

        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }

}

class Productor extends Thread {

    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public  void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Goods(i));
            System.out.println("生产" + i + "个商品");
        }
    }
}

class Consumer extends Thread {

    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public  void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费" + container.pop().id + "个商品");
        }
    }
}

class Goods {
    int id;

    public Goods(int id) {
        this.id = id;
    }
}

class SynContainer {
    Goods[] goods = new Goods[10];
    int count = 0;

    public synchronized void push(Goods good) {
        if (count == goods.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        goods[count] = good;
        count++;
        this.notifyAll();
    }

    public synchronized Goods pop() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Goods good = goods[count];
        this.notifyAll();

        return good;
    }
}