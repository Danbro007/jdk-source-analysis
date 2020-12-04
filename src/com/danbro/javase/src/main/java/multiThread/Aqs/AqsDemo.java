package multiThread.Aqs;

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
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(String.format("线程【%s】获取到锁", Thread.currentThread().getId()));
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                System.out.println(String.format("线程【%s】释放锁", Thread.currentThread().getId()));
                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(String.format("线程【%s】获取到锁", Thread.currentThread().getId()));
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                System.out.println(String.format("线程【%s】释放锁", Thread.currentThread().getId()));
                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(String.format("线程【%s】获取到锁", Thread.currentThread().getId()));
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                System.out.println(String.format("线程【%s】释放锁", Thread.currentThread().getId()));
                lock.unlock();
            }
        }).start();

    }
}
