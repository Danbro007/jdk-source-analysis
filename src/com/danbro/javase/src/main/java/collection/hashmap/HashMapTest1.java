package collection.hashmap;

import java.util.HashMap;

/**
 * @Classname HashMapTest1
 * @Description TODO
 *
 * HashMap 测试代码
 *
 * @Date 2020/8/9 13:45
 * @Author Danrbo
 */
public class HashMapTest1 {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>(16);
        hashMap.put("1","One");
        hashMap.put("2","Two");
        hashMap.put("3","Three");
        hashMap.put("4","Four");
        hashMap.get("1");

    }
}
