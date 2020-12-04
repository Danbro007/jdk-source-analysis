package multiThread.Atomic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @Classname AtomicTest2
 * @Description TODO
 * <p>
 * AtomicMarkableReference 不能解决 ABBA 的问题
 * t1 先把 100 改成 101 标记为 true，然后把 101 改回成 100 标记为 false
 * 之后 t2 把 100 改成 101 标记为 true，虽然最终结果是和我们预期的一样 101 true，但是中间变换过一次，在 t2 处理之前 100 已经不是原来的 100。
 * @Date 2020/8/14 13:01
 * @Author Danrbo
 */
public class AtomicTest2 {
    private static AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference(100, false);


    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                // 变换值和标记
                atomicMarkableReference.compareAndSet(100,101,atomicMarkableReference.isMarked(),!atomicMarkableReference.isMarked());
                atomicMarkableReference.compareAndSet(101,100,atomicMarkableReference.isMarked(),!atomicMarkableReference.isMarked());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                // 变换值和标记
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean r = atomicMarkableReference.compareAndSet(100, 101, atomicMarkableReference.isMarked(), !atomicMarkableReference.isMarked());
            System.out.println(r);
        });

        t1.start();
        t2.start();
    }
}

@Data
@AllArgsConstructor
class User {
    private int id;
    private String name;
}