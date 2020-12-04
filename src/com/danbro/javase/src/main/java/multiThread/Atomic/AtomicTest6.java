package multiThread.Atomic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Classname AtomicTest6
 * @Description TODO
 *
 * 引用类型原子类的使用
 *
 * @Date 2020/8/14 14:58
 * @Author Danrbo
 */
public class AtomicTest6 {
    public static void main(String[] args) {
        AtomicReference<Person> ar = new AtomicReference<Person>();
        Person person = new Person("SnailClimb", 22);
        ar.set(person); // 设置原子引用
        Person updatePerson = new Person("Daisy", 20);
        ar.compareAndSet(person, updatePerson); // 更新

        System.out.println(ar.get().getName());
        System.out.println(ar.get().getAge());
    }
}

@Data
@AllArgsConstructor
class Person {
    private String name;
    private int age;
}
