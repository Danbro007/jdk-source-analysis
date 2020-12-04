package multiThread.ThreadPool;

import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 * @Classname ThreadPoolTest1
 * @Description TODO
 *
 *  Runnalbe 接口和 Callable 接口的区别
 *
 * @Date 2020/8/11 10:11
 * @Author Danrbo
 */
public class ThreadPoolTest1 {
    public static void main(String[] args) throws Exception {
//        test1();
        test2();
    }
    public static void test1() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Future<String> future = threadPool.submit(new Task1());
        System.out.println(future.get());// 线程被阻塞一直在等待结果
        threadPool.submit(new Task2());
    }

    /**
     * submit() 和 execute() 方法的区别
     * @throws Exception
     */
    public static void test2() throws Exception{
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Future<String> future = threadPool.submit(new Task1()); // submit() 适合需要有返回值的既实现了 Callable 接口的
        System.out.println(future.get());// 阻塞式等待
//        System.out.println(future.get(1000,TimeUnit.MILLISECONDS));// 只阻塞的等待 1 秒，超过时间则抛出 TimeoutException 异常
        threadPool.execute(new Task2()); // execute() 适合没有返回值的既实现了 Runnable 接口的
    }

}


class Task1 implements Callable<String>{
    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "callable";
    }
}

class Task2 implements Runnable{
    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(1000);
        System.out.println("Runnable");
    }
}