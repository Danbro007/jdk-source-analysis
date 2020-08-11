package Multithread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname AtomicTest1
 * @Description TODO
 * @Date 2020/8/11 11:04
 * @Author Danrbo
 */
public class AtomicTest1 {
    // 不用对 atomicInteger 加锁也能实现线程安全
    private AtomicInteger atomicInteger = new AtomicInteger();

    public void increment(){
        atomicInteger.incrementAndGet();
    }

    public int getCount(){
        return atomicInteger.get();
    }
}


