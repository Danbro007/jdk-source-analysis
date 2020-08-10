package Multithread.Synchronized;

/**
 * @Classname SingletonTest
 * @Description TODO
 * @Date 2020/8/10 15:48
 * @Author Danrbo
 */
public class SingletonTest {
    private static volatile SingletonTest instance;

    private SingletonTest(){};
    public static SingletonTest getInstance(){
        if (instance == null){
            synchronized (SynchronizedTest1.class){
                if (instance == null){
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        new Thread(()->{

        }).start();
    }
}
