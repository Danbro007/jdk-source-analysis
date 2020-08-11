package Multithread.Aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Classname SemaphoreExample1
 * @Description TODO
 * @Date 2020/8/11 16:19
 * @Author Danrbo
 */
public class SemaphoreExample1 {
    // 请求的数量
    private static final int threadCount = 550;

    public static void main(String[] args) throws InterruptedException {
        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        // 一次只能允许执行的线程数量。
        final Semaphore semaphore = new Semaphore(20);

        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            threadPool.execute(() -> {// Lambda 表达式的运用
                try {
                    semaphore.acquire(5);// 每个线程占用 5 个许可 既可以同时有 20 / 5 = 4 个线程访问
                    test(threadnum);
                    semaphore.release(5);// 释放一个许可
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadnum) throws InterruptedException {
        System.out.println("threadnum:" + threadnum + "---->start");
        Thread.sleep(2000);// 模拟请求的耗时操作
        System.out.println("threadnum:" + threadnum + "---->end");
    }
}
