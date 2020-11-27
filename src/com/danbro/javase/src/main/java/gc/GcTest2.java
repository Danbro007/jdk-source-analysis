package gc;

/**
 * @Classname GCTest2
 * @Description TODO
 *
 * 测试各种垃圾回收器
 *
 * -Xms5m -Xmx5m -XX:+UseSerialGC -XX:+PrintGCDetails
 * 堆内存大小为 5 M，我们创建 6 M 大小的对象。
 * 老年代占堆内存大小为 2/3 * 5
 * 年轻代占堆内存大小 1/3 * 5
 * 当我们放入 6 M 大小的对象时会先放入到年轻代里，由于年轻代放不了则会放入老年代里，
 * 但是老年代也放不下只好抛出堆内存溢出。
 *
 * @Date 2020/8/17 12:33
 * @Author Danrbo
 */
public class GcTest2 {
    public static void main(String[] args) {
        byte[] allocation1;
        allocation1 = new byte[6*1024*1024];
    }
}
