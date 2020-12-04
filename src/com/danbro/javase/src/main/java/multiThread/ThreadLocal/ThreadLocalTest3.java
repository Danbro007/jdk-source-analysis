package multiThread.ThreadLocal;

import java.lang.reflect.Field;

/**
 * @Classname ThreadLocalTest3
 * @Description TODO
 *
 *  测试当在使用 ThreadLocal 的 get() 方法时出现了 GC key 会变成 null 吗
 *
 * @Date 2020/8/13 22:02
 * @Author Danrbo
 */
public class ThreadLocalTest3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        Thread t = new Thread(()->test("abc",false)); // 开启一个线程，没有开启 GC 回收
        t.start();
        t.join();
        System.out.println("--gc后--");
        Thread t2 = new Thread(() -> test("def", true)); // 开启 GC 回收
        t2.start();
        t2.join();
    }

    private static void test(String s,boolean isGC)  {
        try {
            ThreadLocal<Object> threadLocal = new ThreadLocal<>();
            threadLocal.set(s);// 设置 ThreadLocal 的值
            if (isGC) {
                System.gc(); // 开启 GC
            }
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals"); // 获取线程的 threadLocals 属性
            field.setAccessible(true);
            Object ThreadLocalMap = field.get(t); // 获取线程的 ThreadLocalMap
            Class<?> tlmClass = ThreadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");  // 获取 ThreadLocalMap 的 table 属性
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(ThreadLocalMap); //获取 ThreadLocalMap 里的所有值
            for (Object o : arr) {// 遍历存储的内容
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");// 值
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");// key
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.println(String.format("弱引用key:%s,值:%s", referenceField.get(o), valueField.get(o)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
