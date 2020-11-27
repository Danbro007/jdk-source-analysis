import java.util.concurrent.TimeUnit;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/8/28 15:04
 * @Author Danrbo
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        new Thread(()->{
            try {
                a.syncFunc();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            try {
                a.syncFunc();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}


class A {
    public synchronized void syncFunc() throws InterruptedException {
        System.out.println("start syncFunc");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("end syncFunc");
    }
    public void nonSyncFunc() throws InterruptedException {
        System.out.println("start NonSyncFunc");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("end NonSyncFunc");
    }
}