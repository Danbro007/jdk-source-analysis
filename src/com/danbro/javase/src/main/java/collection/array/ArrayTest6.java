package collection.array;

import java.util.ArrayList;

/**
 * @Classname ArrayList6
 * @Description TODO
 *
 * 在迭代的时候删除一个元素会抛出 ConcurrentModificationException 异常
 *
 * @Date 2020/8/7 11:07
 * @Author Danrbo
 */
public class ArrayTest6 {
    public static void main(String[] args) {
        /**
         * 在迭代的时候删除元素错误方式
         *
         * 增强 for 循环底层其实也是调用的迭代器的 hasNext() 和 next() 方法完成循环遍历的，
         * 当使用增强 for 循环的时候会把一个 modCount 的属性赋值给 expectedModCount。
         * modCount 是一个计数器来记录对集合的操作数。当我们在遍历的时候删除元素时会对 modCount++
         * 而 expectedModCount 还是没变化，在执行到迭代器的 next() 方法时会先检查 modCount 与  expectedModCount
         * 是否相等，不相等抛出 ConcurrentModificationException 异常。
         */
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (Integer integer : list) {
            if (integer > 2){
                list.remove(integer);
            }
        }
    }
}
