package Multithread.Atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Classname AtomicTest5
 * @Description TODO
 *
 * 数组类型原子类的测试
 *
 * @Date 2020/8/14 14:39
 * @Author Danrbo
 */
public class AtomicTest5 {
    public static void main(String[] args) {
        int temValue = 0;
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        AtomicIntegerArray i = new AtomicIntegerArray(nums);
        for (int j = 0; j < nums.length; j++) {
            System.out.println(i.get(j));
        }
        temValue = i.getAndSet(0, 2);// 先返回 i[0] ，然后 i[0] = 2
        System.out.println("temvalue:" + temValue + ";  i:" + i); // 1   {2,2,3,4,5,6}
        temValue = i.getAndIncrement(0); // 对 i[0] 的值 + 1
        System.out.println("temvalue:" + temValue + ";  i:" + i);// 2   {3,2,3,4,5,6}
        temValue = i.getAndAdd(0, 5); // 对 i[0] + 5
        System.out.println("temvalue:" + temValue + ";  i:" + i);// 3  {8,2,3,4,5,6}
    }
}
