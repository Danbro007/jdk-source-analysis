package Multithread.Aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Classname LockSupportTest
 * @Description TODO
 * <p>
 * AQS 里 LockSupport 的使用，通过 LockSupport 来唤醒线程和阻塞线程。
 * @Date 2020/11/27 10:18
 * @Author Danrbo
 */
public class LockSupportTest {

    public static void main(String[] args) throws InterruptedException {

        Thread a = new Thread(() -> {
            System.out.println("线程A将出阻塞状态");
            LockSupport.park();
            LockSupport.park();
            System.out.println("线程A被唤醒");
        });
        a.start();

        TimeUnit.SECONDS.sleep(3);
        Thread b = new Thread(() -> {
            System.out.println("线程B唤醒线程A");
            LockSupport.unpark(a);
        });
        b.start();
    }
}
