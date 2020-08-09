package collection;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @Classname ArrayTest7
 * @Description TODO
 *
 * 正确的方式在遍历元素时执行删除操作
 *
 * @Date 2020/8/7 11:19
 * @Author Danrbo
 */
public class ArrayTest7 {
    public static void main(String[] args) {
        /**
         * 正确方式是使用迭代器在遍历元素的时候删除元素
         * 使用迭代器删除元素时会先检查 modCount 和 expectedModCount 是否相等，然后再执行删除操作。
         */
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next > 2){
                iterator.remove();
            }
        }
    }
}
