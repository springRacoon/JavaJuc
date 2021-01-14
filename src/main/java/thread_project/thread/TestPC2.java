package thread_project.thread;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-12 15:29
 */
public class TestPC2 {

    public static void main(String[] args) {

        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

class Player extends Thread{

    TV tv;

    public Player(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2 ==0){
                this.tv.play("节目1");
            }else{
                this.tv.play("节目2");
            }
        }
    }
}

class Watcher extends Thread{
    TV tv;

    public Watcher(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

class TV{
    String voice;

    boolean flag = true;

    public synchronized void play(String voice){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("表演了:"+voice);
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }

    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了"+voice);
        this.notifyAll();
        this.flag = !this.flag;

    }
}
