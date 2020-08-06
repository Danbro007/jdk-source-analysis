package generics;

/**
 * @Classname JavaGenericsTest2
 * @Description TODO
 *
 * 演示泛型类
 *
 * @Date 2020/8/5 11:36
 * @Author Danrbo
 */
public class JavaGenericsTest2 {
    public static void main(String[] args) {
        // 实例化泛型类
        Generic<Integer> generic = new Generic<>(12345);
        System.out.println(generic.getKey());
    }
}

class Generic<T>{
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
}
