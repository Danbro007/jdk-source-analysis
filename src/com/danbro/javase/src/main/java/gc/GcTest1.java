package gc;

/**
 * @Classname Test1
 * @Description TODO
 *
 * Full GC 与 Minor GC 不同
 *
 * @Date 2020/8/16 14:28
 * @Author Danrbo
 */
public class GcTest1 {

    public static void main(String[] args) {
        byte[] allocation1, allocation2,allocation3,allocation4,allocation5;
        allocation1 = new byte[43900*1024];
        allocation2 = new byte[1000*1024];
        allocation3 = new byte[1000*1024];
        allocation4 = new byte[1000*1024];


    }
}
