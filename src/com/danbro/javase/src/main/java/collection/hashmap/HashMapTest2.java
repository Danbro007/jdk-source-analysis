package collection.hashmap;

import java.util.HashMap;

/**
 * @Classname HashMapTest2
 * @Description TODO
 *
 * 测试 HashMap 的 resize()(扩容方法)
 *
 * @Date 2020/8/9 13:51
 * @Author Danrbo
 */
public class HashMapTest2 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>(4);
        hashMap.put(1,"one");
        hashMap.put(2,"two");
        hashMap.put(3,"three");
        hashMap.put(4,"four");
        hashMap.put(5,"five");
    }
}
