package multiThread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname AtomicTest4
 * @Description TODO
 *
 *  基本类型原子类的使用方法
 *
 * @Date 2020/8/14 14:30
 * @Author Danrbo
 */
public class AtomicTest4 {
    public static void main(String[] args) {
        int temValue = 0;
        AtomicInteger i = new AtomicInteger(temValue);
        temValue = i.getAndSet(3);
        System.out.println("temvalue:" + temValue + ";  i:" + i);//temvalue:0;  i:3
        temValue = i.getAndIncrement();
        System.out.println("temvalue:" + temValue + ";  i:" + i);//temvalue:3;  i:4
        temValue = i.getAndAdd(5);
        System.out.println("temvalue:" + temValue + ";  i:" + i);//temvalue:4;  i:9
    }
}
