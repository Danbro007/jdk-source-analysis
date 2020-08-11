package Multithread.ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @Classname ThreadLocalTest1
 * @Description TODO
 * @Date 2020/8/10 20:20
 * @Author Danrbo
 */
public class ThreadLocalTest1 implements Runnable{
    private static final ThreadLocal<SimpleDateFormat> FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest1 obj = new ThreadLocalTest1();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }

        System.out.println("结束");
    }


    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+FORMAT_THREAD_LOCAL.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FORMAT_THREAD_LOCAL.set(new SimpleDateFormat());

        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+FORMAT_THREAD_LOCAL.get().toPattern());
    }
}
