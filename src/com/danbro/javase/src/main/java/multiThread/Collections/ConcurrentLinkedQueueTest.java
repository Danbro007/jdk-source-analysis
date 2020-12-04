package multiThread.Collections;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname ConcurrentLinkedQueueTest
 * @Description TODO
 * @Date 2020/8/11 21:49
 * @Author Danrbo
 */
public class ConcurrentLinkedQueueTest {
    private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            int num = i;
            threadPool.execute(()->{
                queue.add(num);
            });
        }
    }
}
