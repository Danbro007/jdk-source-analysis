package Multithread.Atomic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Classname AtomicTest9
 * @Description TODO
 *
 * AtomicIntegerFieldUpdater 类使用示例
 *
 * @Date 2020/8/14 16:44
 * @Author Danrbo
 */
public class AtomicTest9 {
    public static void main(String[] args) {
        // 指定要更新的类和属性
        AtomicIntegerFieldUpdater<People> a = AtomicIntegerFieldUpdater.newUpdater(People.class, "age");

        People people = new People( 22,"Java");
        System.out.println(a.getAndIncrement(people));// 22 更新 age 属性 对 age + 1
        System.out.println(a.get(people));// 23
    }
}

@Data
@AllArgsConstructor
class People{
    private Integer age;
    private String name;
}