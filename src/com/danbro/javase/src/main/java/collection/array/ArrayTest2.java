package collection.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ArrayTest2
 * @Description TODO
 * @Date 2020/8/5 14:34
 * @Author Danrbo
 */
public class ArrayTest2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String s : list) {
            if (s.equals("2")){
                list.remove(s);
            }
        }
        System.out.println(list);
    }
}
