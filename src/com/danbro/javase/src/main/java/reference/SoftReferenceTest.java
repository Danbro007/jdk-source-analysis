package reference;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @Classname SoftReferenceTest
 * @Description TODO 软引用测试 把堆最大设置为 20 MB -Xmx20M
 * @Date 2020/12/4 11:14
 * @Author Danrbo
 */
public class SoftReferenceTest {
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(m.get());
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());
        // 再在堆上建一个 15 MB 的数据导致内存不足，垃圾回收会自动启动，把 m 这个软引用对象回收掉。
        byte[] b = new byte[1024 * 1024 * 15];
        System.out.println(m.get());

    }
}
