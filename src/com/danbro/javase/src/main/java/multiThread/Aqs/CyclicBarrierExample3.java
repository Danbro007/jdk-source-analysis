package multiThread.Aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname CyclicBarrierExample3
 * @Description TODO
 * @Date 2020/8/11 20:43
 * @Author Danrbo
 */
public class CyclicBarrierExample3 {
    // 请求的数量
    private static final int THREAD_COUNT = 550;
    // 需要同步的线程数量
    private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5, () -> {
        System.out.println("------当线程数达到之后，优先执行------");
    });

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < THREAD_COUNT; i++) {
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
        CYCLIC_BARRIER.await();// 阻塞等待
        System.out.println("threadnum:" + threadnum + "is finish");
    }

}