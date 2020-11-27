package Multithread.Aqs;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname AqsDemo
 * @Description TODO 开启 a、b、c 三个线程，测试 AQS 的使用。
 * @Date 2020/11/27 13:27
 * @Author Danrbo
 */
public class AqsDemo {
    @SneakyThrows
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread a = new Thread((() -> {
            lock.lock();
            try {
                TimeUnit.MINUTES.sleep(20);
            } catch (InterruptedException e) {
                lock.unlock();
            }
        }));
        a.start();
        TimeUnit.SECONDS.sleep(1);
        Thread b = new Thread((() -> {
            lock.lock();
            try {
                TimeUnit.MINUTES.sleep(20);
            } catch (InterruptedException e) {
                lock.unlock();
            }
        }));
        b.start();
        TimeUnit.SECONDS.sleep(1);
        Thread c = new Thread((() -> {
            lock.lock();
            try {
                TimeUnit.MINUTES.sleep(20);
            } catch (InterruptedException e) {
                lock.unlock();
            }
        }));
        c.start();

    }
}
