package reference;

import java.io.IOException;

/**
 * @Classname NormalReference
 * @Description TODO 强引用测试
 * @Date 2020/12/4 11:08
 * @Author Danrbo
 */
public class StrongReferenceTesst {

    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        // 垃圾回收
        System.gc();
        System.out.println(m);
        // 阻塞主线程直到垃圾回收完成
        System.in.read();
    }
}


