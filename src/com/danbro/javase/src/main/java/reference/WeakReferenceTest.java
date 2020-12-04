package reference;

import java.lang.ref.WeakReference;

/**
 * @Classname WeakReferenceTest
 * @Description TODO 弱引用测试
 *
 * 弱引用不管内存够不够都会被 GC 回收
 *
 * @Date 2020/12/4 11:28
 * @Author Danrbo
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
    }
}
