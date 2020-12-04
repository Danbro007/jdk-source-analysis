package multiThread.Atomic;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname AtomicTest1
 * @Description TODO
 * <p>
 * 演示原子性的线程安全
 * @Date 2020/8/11 11:04
 * @Author Danrbo
 */
public class AtomicTest1 {
    // 不用对 atomicInteger 加锁也能实现线程安全
    private static int COUNT = 1000;
    private static AtomicInteger atomicInteger = new AtomicInteger();
    private static int num = 0;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(COUNT);
    private static CountDownLatch countDownLatch = new CountDownLatch(COUNT);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            threadPool.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    atomicInteger.getAndIncrement();
                    num += 1;
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }
        countDownLatch.await(); // 阻塞等待，直到计数器为 0 。
        System.out.println("atomicInteger 结果：" + atomicInteger.get()); // 准确的 线程安全
        System.out.println("num 结果：" + num); // 线程不安全
    }
}


