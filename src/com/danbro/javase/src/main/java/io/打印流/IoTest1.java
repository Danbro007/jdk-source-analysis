package io.打印流;

import java.io.*;

/**
 * @Classname IoTest1
 * @Description TODO
 *
 * 测试打印输出流，把字符串记录的文件上。
 *
 * @Date 2020/8/18 11:16
 * @Author Danrbo
 */
public class IoTest1 {
    private static final String SOURCE = "D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\打印流\\file01.txt";
    private static final String TARGET = "D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\打印流\\file02.txt";
    public static void main(String[] args) throws IOException {
//        method1();
        method2();
    }

    public static void method1() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(SOURCE),true);
        writer.write("测试打印流");
        writer.println("此句之后换行");
        writer.println("特有功能：自动换行和自动刷新");
        writer.println("利用构造器设置自动刷新");
    }

    /**
     * 用 PrintWriter 复制文件
     * @throws IOException
     */
    public static void method2() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(TARGET));
        BufferedReader reader = new BufferedReader(new FileReader(SOURCE));
        String line;
        while ((line = reader.readLine())!=null){
            writer.write(line);
            writer.write("\r\n");
        }
        writer.close();
        reader.close();
    }
}
