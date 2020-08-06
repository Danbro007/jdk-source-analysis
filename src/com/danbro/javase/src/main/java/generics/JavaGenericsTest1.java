package generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname JavaGenericsTest
 * @Description TODO
 *
 *
 *
 * @Date 2020/8/5 11:30
 * @Author Danrbo
 */
public class JavaGenericsTest1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        //添加与泛型不相同的元素会报错
//        list.add("1")
        // 通过反射可以获取 add 方法，指定参数类型为 Object,最后调用 add 方法添加与泛型不相符的元素
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        add.invoke(list,"1");
        System.out.println(list);
    }
}
