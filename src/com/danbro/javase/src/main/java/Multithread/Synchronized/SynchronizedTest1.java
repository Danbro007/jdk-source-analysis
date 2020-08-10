package Multithread.Synchronized;

/**
 * @Classname SynchronizedTest1
 * @Description TODO
 * <p>
 * 测试对静态方法、实例方法、对象加锁的效果
 * @Date 2020/8/10 15:27
 * @Author Danrbo
 */
public class SynchronizedTest1 {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Test.staticMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Test test = new Test();
        new Thread(() -> {
            try {
                test.instanceMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                test.codeBlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}


class Test {


    public static synchronized void staticMethod() throws InterruptedException {
        System.out.println("静态方法");
        Thread.sleep(2000);
    }


    public synchronized void instanceMethod() throws InterruptedException {
        System.out.println("实例方法"); // 对 synchronized 的方法要先获取获取实例对象的锁
        Thread.sleep(2000);
    }


    public void codeBlock() throws InterruptedException {
        synchronized (this) { // 要先获取 synchronized 里的对象锁
            System.out.println("同步代码块");
            Thread.sleep(2000);
        }
    }

}
