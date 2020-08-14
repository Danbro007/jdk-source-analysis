package Multithread.ThreadPool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Classname DynamicThreadPool
 * @Description TODO
 *  根据美团技术团队的文章实现一个动态的线程池，可以在线程池运行的时候调整线程数，线程池大小以及线程池的阻塞队列大小。
 *
 * @Date 2020/8/13 20:19
 * @Author Danrbo
 */
public class ThreadPoolTest3 {

    public static void main(String[] args) throws InterruptedException {
        dynamicModifyThreadPool();
    }

    /**
     * 返回一个线程池，线程池的核心线程数为 2 个，最大线程数是 10 个。
     * @return 线程池
     */
    public static ThreadPoolExecutor getThreadPoolExecutor(){
        return new ThreadPoolExecutor(2,
                5,
                1,
                TimeUnit.SECONDS,
                new MyLinkedBlockingQueue<>(20),
                new NameThreadFactory("Test"));
    }

    /**
     *
     */
    public static void dynamicModifyThreadPool() throws InterruptedException {
        ThreadPoolExecutor poolExecutor = getThreadPoolExecutor();
        for (int i = 0; i < 15; i++) {
             poolExecutor.execute(()->{
                 threadPoolStatus(poolExecutor,"创建线程");
                 try {
                     TimeUnit.SECONDS.sleep(10);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             });
        }
        threadPoolStatus(poolExecutor,"改变之前");
        poolExecutor.setCorePoolSize(10); // 动态的修改核心线程数
        poolExecutor.setMaximumPoolSize(10); // 修改最大线程数
        MyLinkedBlockingQueue queue = (MyLinkedBlockingQueue) poolExecutor.getQueue();
        queue.setCapacity(30); // 修改阻塞队列大小
        threadPoolStatus(poolExecutor,"改变之后");
        Thread.currentThread().join();

    }


    public static void threadPoolStatus(ThreadPoolExecutor executor,String name){
        MyLinkedBlockingQueue<Runnable> queue = (MyLinkedBlockingQueue)executor.getQueue();
        System.out.println(Thread.currentThread().getName() + "-" +name + "-:" +
                "核心线程数：" + executor.getCorePoolSize() +
                "活动线程数：" + executor.getActiveCount() +
                "最大线程数：" + executor.getMaximumPoolSize() +
                "线程池活跃度：" + divide(executor.getActiveCount(),executor.getMaximumPoolSize()) +
                "任务完成数：" + executor.getCompletedTaskCount() +
                "队列大小：" + (queue.size() + queue.remainingCapacity() +
                "当前排队任务线程：" + queue.size() +
                "任务剩余大小：" + queue.remainingCapacity() +
                "队列实用度：" + divide(queue.size(),queue.size() + queue.remainingCapacity())));

    }

    private static String divide(int num1,int num2) {
        return String.format("%1.2f%%",Double.parseDouble(num1 + "")/Double.parseDouble(num2 + "") * 100);
    }
}
