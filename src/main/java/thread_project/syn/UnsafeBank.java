package thread_project.syn;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-11 15:43
 */
public class UnsafeBank {

    public static void main(String[] args) {

        Account account = new Account(100, "张三");

        Drawing one = new Drawing(account, 50, "李四");
        Drawing two = new Drawing(account, 100, "王五");

        one.start();
        two.start();
    }
}

class Account {

    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread {
    Account account;

    int drawingMoney;

    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        if (account.money - drawingMoney < 0) {
            System.out.println(Thread.currentThread().getName() + "钱不够");
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money = account.money - drawingMoney;
        nowMoney = nowMoney + drawingMoney;

        System.out.println(account.name + "余额为:" + account.money);
        System.out.println(this.getName() + "手里的钱:" + nowMoney);
    }
}
