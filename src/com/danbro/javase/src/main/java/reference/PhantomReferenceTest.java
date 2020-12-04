package reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Classname PhantomReferenceTest
 * @Description TODO 虚引用测试 JVM:-Xmx20M  虚引用对象会先被放入引用队列里，GC 线程会在引用队列里不断的查找虚引用对象，找到了再把它回收了。
 *
 * 虚引用的用途是为了能管理堆外内存来实现零拷贝，虚引用可以直接指向堆外的Buffer，这样可以不用把堆外的数据拷贝到堆内，减少了不必要的IO提高了效率。
 *
 * @Date 2020/12/4 11:40
 * @Author Danrbo
 */
public class PhantomReferenceTest {
    static List<byte[]> LIST = new ArrayList();
    static ReferenceQueue QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) {
        PhantomReference phantomReference = new PhantomReference<>(new M(), QUEUE);
        System.out.println(phantomReference.get());
        new Thread(() -> {
            while (true) {
                LIST.add(new byte[1024 * 1024]);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(phantomReference.get());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Reference reference = QUEUE.poll();
                if (reference != null) {
                    System.out.println("虚引用被GC回收了" + reference);
                }
            }
        }).start();
    }
}
