package io.字节流;

import java.io.*;

/**
 * @Classname IoTest
 * @Description TODO
 * @Date 2020/8/17 16:34
 * @Author Danrbo
 */
public class IoTest {
    public static void main(String[] args) throws IOException {
        File file01 = new File("D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\字节流\\pic01.png");
        File file02 = new File("D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\字节流\\pic02.png");
        method1(file01, file02);
    }

    public static void method1(File file01, File file02) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream inputStream = new FileInputStream(file01.getAbsoluteFile());
        FileOutputStream outputStream = new FileOutputStream(file02.getAbsoluteFile());
        byte[] bytes = new byte[1024];
        int ch;
        while ((ch = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, ch);
        }
        inputStream.close();
        outputStream.close();
        System.out.println("字节流耗时：" + (System.currentTimeMillis() - start) + "ms");
    }
}
