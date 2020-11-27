package gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @Classname ReferenceTest1
 * @Description TODO
 * @Date 2020/8/17 12:08
 * @Author Danrbo
 */
public class ReferenceTest1 {
    public static void main(String[] args) {
        User user = new User();
        ReferenceQueue<User> referenceQueue = new ReferenceQueue<>();
        PhantomReference<User> phantomReference = new PhantomReference<User>(user,referenceQueue);// 当虚引用被回收时会先放入引用队列里，然后触发类的 finalize() 方法
        user = null;
        System.gc();

    }
}

class User{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("被回收了");
    }
}

