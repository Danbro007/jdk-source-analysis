package Multithread.Atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Classname AtomicTest7
 * @Description TODO
 *
 * AtomicStampedReference 的使用，原子更新带有版本号，能解决 ABBA 的问题
 *
 * @Date 2020/8/14 16:12
 * @Author Danrbo
 */
public class AtomicTest7 {
    public static void main(String[] args) {
        // 实例化、取当前值和 stamp 值
        final Integer initialRef = 0, initialStamp = 0; // initialStamp 可以是时间戳
        final AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(initialRef, initialStamp);
        System.out.println("currentValue=" + asr.getReference() + ", currentStamp=" + asr.getStamp());// 打印当前的原子类的引用和 Stamp

        // compare and set
        final Integer newReference = 666, newStamp = 999;
        final boolean casResult = asr.compareAndSet(initialRef, newReference, initialStamp, newStamp); // 更新引用和 Stamp
        System.out.println("currentValue=" + asr.getReference()// 666
                + ", currentStamp=" + asr.getStamp()// 999
                + ", casResult=" + casResult);  // true

        // 获取当前的值和当前的 stamp 值
        int[] arr = new int[1];  // {0}
        final Integer currentValue = asr.get(arr);// 修改 arr[0] 设置为 asr.stamp 既 999 并返回对象既 666
        final int currentStamp = arr[0];//999
        System.out.println("currentValue=" + currentValue + ", currentStamp=" + currentStamp); // 666 999

        // 单独设置 stamp 值
        final boolean attemptStampResult = asr.attemptStamp(newReference, 88);// 尝试设置 stamp 成功返回 true 失败为 false
        System.out.println("currentValue=" + asr.getReference()// 666
                + ", currentStamp=" + asr.getStamp() // 88
                + ", attemptStampResult=" + attemptStampResult);// true

        // 重新设置当前值和 stamp 值
        asr.set(initialRef, initialStamp);
        System.out.println("currentValue=" + asr.getReference() + ", currentStamp=" + asr.getStamp());// 0 0

        // [不推荐使用，除非搞清楚注释的意思了] weak compare and set
        // 困惑！weakCompareAndSet 这个方法最终还是调用 compareAndSet 方法。[版本: jdk-8u191]
        // 但是注释上写着 "May fail spuriously and does not provide ordering guarantees,
        // so is only rarely an appropriate alternative to compareAndSet."
        // todo 感觉有可能是 jvm 通过方法名在 native 方法里面做了转发
        final boolean wCasResult = asr.weakCompareAndSet(initialRef, newReference, initialStamp, newStamp);
        System.out.println("currentValue=" + asr.getReference()
                + ", currentStamp=" + asr.getStamp()
                + ", wCasResult=" + wCasResult);
    }
}
