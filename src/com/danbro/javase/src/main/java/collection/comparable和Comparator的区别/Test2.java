package collection.comparable和Comparator的区别;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Test2
 * @Description TODO
 *
 * comparator 接口的测试
 *
 * @Date 2020/8/7 10:41
 * @Author Danrbo
 */
public class Test2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(13);
        list.add(100);
        list.add(1);
        list.add(2);
        list.add(34);
        list.sort((o1, o2) -> {
            if (o1 > o2) {
                return 1;
            }
            if (o1.equals(o2)) {
                return 0;
            }
            return -1;
        });
        list.forEach(System.out::println);
    }
}


