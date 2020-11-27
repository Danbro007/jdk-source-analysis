package io.随机访问文件;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Classname IoTest
 * @Description TODO
 * @Date 2020/8/18 12:20
 * @Author Danrbo
 */
public class IoTest {
    private final static String FILEPATH = "D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\随机访问文件\\file.txt";

    public static void main(String[] args) throws IOException {
        write();
        RandomAccessFile raf = new RandomAccessFile(FILEPATH, "r");
        raf.seek(6*1);//读第二个人
        byte[] buf=new byte[6];
        raf.read(buf);
        String name=new String(buf);
        System.out.println("name="+name);
        raf.seek(12);// 指定指针的位置
        int age=raf.readInt();
        System.out.println("age="+age);
        raf.close();
    }


    public static void write() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(FILEPATH,"rw");
        raf.write("张三".getBytes()); // 张三在 utf8 里占用 6 个字节
        raf.write("李四".getBytes());
        raf.seek(6*2);//把指针设置到 16 的位置
        raf.writeInt(23);
        raf.write("王五".getBytes());
        System.out.println(raf.getFilePointer()); // 返回当前文件的指针位置
        raf.close();
    }
}
