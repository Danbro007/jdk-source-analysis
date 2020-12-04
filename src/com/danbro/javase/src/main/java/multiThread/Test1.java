package multiThread;

/**
 * @Classname Test1
 * @Description TODO
 * @Date 2020/8/16 19:35
 * @Author Danrbo
 */
public class Test1 {
    public static void main(String[] args) {
        Task task = new Task();
        task.start();
        task.start();
    }
}
class Task extends Thread {

    @Override
    public void run() {
        System.out.println("run");
    }
}