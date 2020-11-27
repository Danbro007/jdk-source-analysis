package io.转换流;

import java.io.*;

/**
 * @Classname IoTest
 * @Description TODO
 *
 *  输入内容（输入字符流） ------> 文件（输出字节流）
 * @Date 2020/8/17 16:56
 * @Author Danrbo
 */
public class IoTest01 {
    private final static String FILENAME01 = "D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\转换流\\file01.txt";
    private final static String FILENAME02 = "D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\转换流\\file02.txt";
    private final static String FILENAME03 = "D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\转换流\\file03.txt";
    public static void main(String[] args) throws IOException {
        method1();
//        method2();
//        method3();
    }


    public static void method1() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer = new FileWriter(FILENAME01); // 字节流
        int len;
        char[] chars = new char[1024];
        while ((len = reader.read(chars)) != -1) {
            writer.write(chars, 0, len);
            writer.flush();
        }
        writer.close();
        reader.close();
    }

    public static void method2() throws IOException {
        InputStream in = System.in;
        FileWriter writer = new FileWriter(FILENAME02);
        int len;
        byte[] bytes = new byte[1024];
        while ((len = in.read(bytes)) != -1) {
            writer.write(new String(bytes,0,len));
            writer.flush();
        }
        writer.close();
        in.close();
    }


    public static void method3() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        FileWriter writer = new FileWriter(FILENAME03);
        int len;
        char[] chars = new char[1024];
        while ((len = reader.read(chars)) != -1) {
            writer.write(chars, 0, len);
            writer.flush();
        }
        writer.close();
        reader.close();
    }
}
