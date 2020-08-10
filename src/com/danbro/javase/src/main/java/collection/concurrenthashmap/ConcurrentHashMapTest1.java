package collection.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname ConcurrentHashMap
 * @Description TODO
 * @Date 2020/8/9 17:19
 * @Author Danrbo
 */
public class ConcurrentHashMapTest1 {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(16);
        map.put("1","one");
        map.put("2","two");
        map.get("1");
    }
}

