package multiThread.ThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * @Classname ThreadLocalTest4
 * @Description TODO 测试本地线程存储䘝 ThreadLocal 变量 其他线程能不能取到
 * @Date 2020/12/4 13:39
 * @Author Danrbo
 */
public class ThreadLocalTest4 {
    private static ThreadLocal<Person> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Person person = threadLocal.get();
            System.out.println(person);
        }).start();
        new Thread(()->{
            threadLocal.set(new Person("danbro"));
        }).start();
    }
}


class Person{
    public String name;

    public Person(String name) {
        this.name = name;
    }
}
