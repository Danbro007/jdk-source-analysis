package collection;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Classname ArrayTest3
 * @Description TODO
 * @Date 2020/8/5 20:53
 * @Author Danrbo
 */
public class ArrayTest3 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        ArrayList<String> list = new ArrayList<>(set);
        list.add("4");

    }
}
