package io.字符流;

import java.io.*;

/**
 * @Classname IOTest1
 * @Description TODO
 *
 * 使用字符流读取文件
 *
 * @Date 2020/8/17 16:00
 * @Author Danrbo
 */
public class IoTest1 {
    public static void main(String[] args) throws IOException {
        File file01 = new File("D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\字符流\\file01.txt");
        File file02 = new File("D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\字符流\\file02.txt");
        File file03 = new File("D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\字符流\\file03.txt");
        FileReader reader = new FileReader(file01.getAbsoluteFile());
        FileWriter writer01 = new FileWriter(file02.getAbsoluteFile());
        FileWriter writer02 = new FileWriter(file03.getAbsoluteFile());
        method1(reader, writer01);
        method2(reader, writer02);
        reader.close();
        writer02.close();
        writer01.close();
    }

    public static void method1(Reader reader, Writer writer) throws IOException {
        int ch;
        while ((ch = reader.read()) != -1) {
            writer.write(ch);// 一个个读取字符
        }
        writer.flush();
    }

    public static void method2(Reader reader, Writer writer) throws IOException {
        char[] charArray = new char[1024]; // 读取到字符数组里
        int len;
        while ((len = reader.read(charArray)) != -1) {
            writer.write(charArray,0,len);
        }
        writer.flush();
    }
}
