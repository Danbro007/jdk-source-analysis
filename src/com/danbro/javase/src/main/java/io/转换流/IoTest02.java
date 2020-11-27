package io.转换流;

import java.io.*;

/**
 * @Classname IoTest02
 * @Description TODO
 * <p>
 * 读取文件（输入字节流）------> 打印（输出字符流）
 * @Date 2020/8/17 22:00
 * @Author Danrbo
 */
public class IoTest02 {
    private final static String FILENAME = "D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\转换流\\Copy.java";

    public static void main(String[] args) throws IOException {
//        method1();
//        method2();
        method3();
    }

    public static void method1() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.write("\r\n");//换行
        }
        reader.close();
        writer.close();
    }

    public static void method2() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.write("\r\n");//换行
        }
        reader.close();
        writer.close();
    }

    public static void method3() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
        PrintStream out = System.out;
        String line;
        while ((line = reader.readLine()) != null){
            out.write(line.getBytes());
            out.write("\r\n".getBytes());//换行
        }
    }
}
