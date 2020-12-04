package multiThread.ThreadLocal;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ThreadLocalTest2
 * @Description TODO
 * @Date 2020/8/13 21:24
 * @Author Danrbo
 */
public class ThreadLocalTest2 {
    private List<String> messages = new ArrayList<>();

    public static final ThreadLocal<ThreadLocalTest2> HOLDER = ThreadLocal.withInitial(ThreadLocalTest2::new); // threadLocal里放了一个 ThreadLocalTest2 对象

    public static void add(String message) {
        HOLDER.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = HOLDER.get().messages;
        HOLDER.remove();// 删除
        System.out.println("size: " + HOLDER.get().messages.size());
        return messages;
    }

    public static void main(String[] args) {
        ThreadLocalTest2.add("一枝花算不算浪漫");
        System.out.println(HOLDER.get().messages);
        ThreadLocalTest2.clear();
    }
}
