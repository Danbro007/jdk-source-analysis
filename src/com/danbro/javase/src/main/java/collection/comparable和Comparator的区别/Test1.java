package collection.comparable和Comparator的区别;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.TreeMap;

/**
 * @Classname Test1
 * @Description TODO
 *
 * comparable 接口的使用
 *
 * @Date 2020/8/7 10:19
 * @Author Danrbo
 */
public class Test1 {
    public static void main(String[] args) {

        TreeMap<User, String> treeMap = new TreeMap<>();
        treeMap.put(new User(2, "Max"), "Max");
        treeMap.put(new User(1, "John"), "John");
        treeMap.put(new User(6, "Wang"), "Wang");
        treeMap.put(new User(7, "Li"), "Li");


        treeMap.keySet().forEach(System.out::println);

    }
}

@Data
@AllArgsConstructor
class User implements Comparable<User> {
    private int id;
    private String username;

    @Override
    public int compareTo(User o) {
        if (this.getId() > o.getId()) {
            return 1;
        }
        if (this.getId() == o.getId()) {
            return 0;
        }
        return -1;
    }
}