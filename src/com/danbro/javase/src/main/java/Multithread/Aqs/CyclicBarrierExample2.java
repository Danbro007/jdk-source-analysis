package Multithread.Aqs;

import java.util.concurrent.*;

/**
 * @Classname CyclicBarrierExample2
 * @Description TODO
 * @Date 2020/8/11 20:37
 * @Author Danrbo
 */
public class CyclicBarrierExample2 {
    // 请求的数量
    private static final int THREAD_COUNT = 550;
    // 需要同步的线程数量
    private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < THREAD_COUNT; i++) { // 550 个任务
            final int threadNum = i;
            Thread.sleep(1000);
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }

    public static void test(int threadnum) throws InterruptedException, BrokenBarrierException {
        System.out.println("threadnum:" + threadnum + "is ready");
        try {
            /**等待60秒，保证子线程完全执行结束*/
            CYCLIC_BARRIER.await(60, TimeUnit.SECONDS); // 阻塞等待，当 5 个线程都执行完会执行下面的操作
        } catch (Exception e) {
            System.out.println("-----CyclicBarrierException------");
        }
        System.out.println("threadnum:" + threadnum + "is finish");
    }

}